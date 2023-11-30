package com.startdis.sys.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sys.domain.model.entity.FileInfo;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 上传的文件信息表(FileInfo)服务定义层
 */
public interface FileInfoService extends IService<FileInfo> {

    ResultBean fileList(String fileName);

    ResultBean getFileById(String id);
}
