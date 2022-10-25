package com.startdis.common.web.socket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-07-15
 * @desc
 */
@Component
public class CustomWebSocketHandler extends TextWebSocketHandler {

    private static Logger log = LoggerFactory.getLogger(CustomWebSocketHandler.class);

    @Resource(name = "socketMessageTaskPool")
    private ThreadPoolTaskExecutor socketMessageExecutor;

    /**
     * 保存连接的会话
     */
    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(),session);
        log.info("连接已建立，会话ID：" + session.getId() + "，客户端地址：" + session.getRemoteAddress());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("接受到消息：" + message.getPayload());
        pushMsg(session.getId(),message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        exception.printStackTrace();
        log.info("消息传输出错！");
    }

    /**
     * 连接关闭移除会话
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
        log.info("连接被关闭，会话ID：" + session.getId() + "，客户端地址：" + session.getRemoteAddress());
    }

    /**
     * 向客户端推送消息
     *
     * @param msg 文本消息
     */
    public void pushMsg(String id,String msg) {
        SocketMsg socketMsg = new SocketMsg(id, msg, sessions);
        socketMessageExecutor.execute(socketMsg);
    }

    static class SocketMsg implements Runnable{
        private String id;
        private String msg;
        private ConcurrentHashMap<String, WebSocketSession> sessions;

        public SocketMsg(String id, String msg, ConcurrentHashMap sessions) {
            this.id = id;
            this.msg = msg;
            this.sessions = sessions;
        }

        @Override
        public void run() {
            log.info("通过自定义线程{},回复了客户端{}消息：{}。",Thread.currentThread().getName(),id,msg);
            final Collection<WebSocketSession> webSocketSessions = sessions.values();
            final TextMessage textMessage = new TextMessage(msg);
            webSocketSessions.forEach(s -> {
                try {
                    if (s.getId().equals(id)) {
                        s.sendMessage(textMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
