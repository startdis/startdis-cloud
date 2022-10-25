package com.startdis.system.server.service;

import com.startdis.system.domain.model.dto.post.RegisterDTO;

/**
 * <p>
 * 启迪 服务类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
public interface StartdisService {
    
    String register(RegisterDTO registerDTO);
}
