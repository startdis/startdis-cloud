package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sys.domain.model.entity.FileInfo;
import com.startdis.sys.infra.mapper.FileInfoMapper;
import com.startdis.sys.server.service.FileInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 上传的文件信息表(FileInfo)服务实现层
 */
@Service("fileInfoService")
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements FileInfoService {

    @Override
    public ResultBean fileList(String fileName) {
        List<FileInfo> fileInfos = this.baseMapper.selectList(Wrappers.<FileInfo>lambdaQuery()
                .like(StringUtils.isNotEmpty(fileName), FileInfo::getFileName, fileName));
        return ResultBean.success(fileInfos);
    }

    @Override
    public ResultBean getFileById(String id) {
        FileInfo fileInfo = super.getById(id);
        return ResultBean.success(fileInfo);
    }
}

