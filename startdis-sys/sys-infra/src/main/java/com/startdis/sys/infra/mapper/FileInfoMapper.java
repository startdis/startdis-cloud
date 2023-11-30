package com.startdis.sys.infra.mapper;

import com.startdis.sys.domain.model.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 上传的文件信息表(FileInfo)数据层
 */
@Mapper
public interface FileInfoMapper extends BaseMapper<FileInfo> {

}
