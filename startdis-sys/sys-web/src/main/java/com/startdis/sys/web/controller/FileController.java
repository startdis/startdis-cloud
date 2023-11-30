package com.startdis.sys.web.controller;

import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.minio.domian.FileInfoVO;
import com.startdis.comm.minio.service.MinIOService;
import com.startdis.comm.util.auth.AuthInfoUtils;
import com.startdis.comm.util.file.FileKits;
import com.startdis.sys.domain.model.entity.FileInfo;
import com.startdis.sys.server.service.FileInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Ydsz
 * @email limengwei@njydsz.com
 * @desc 文件操作（MinIO）控制层
 */
@RefreshScope
@RestController
@Api(tags = "文件操作接口")
@RequestMapping(value = "/file")
public class FileController {
    
    @Resource
    MinIOService minIOService;

    @Resource
    FileInfoService fileInfoService;
    
    @Value("${minio.bucketName}")
    private String bucketName;
    
    @ApiOperation(value = "上传一个文件")
    @PostMapping("/upload")
    @RbacPermission
    public ResultBean upload(@RequestParam(name = "multipartFile") MultipartFile multipartFile) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        String filename = multipartFile.getOriginalFilename();
        filename = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
        minIOService.uploadFile(bucketName, groupTenantId + "/" + companyTenantId + "/" + filename,
                multipartFile.getInputStream());
        FileInfo fileInfo = FileInfo.builder().fileName(multipartFile.getOriginalFilename()).fileUrl(filename).fileSize(FileKits.formatSize(multipartFile.getSize())).status(1).deleted(0).build();
        fileInfoService.save(fileInfo);
        return ResultBean.success("上传成功", fileInfo);
    }

    @ApiOperation("下载一个文件")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @RbacPermission
    public void downloadFile(@RequestParam String objectName, HttpServletResponse response) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        InputStream stream = minIOService.download(bucketName, groupTenantId + "/" + companyTenantId + "/" + objectName);
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(objectName.substring(objectName.lastIndexOf("/") + 1), "UTF-8"));
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        IOUtils.copy(stream, response.getOutputStream());
    }

    @GetMapping("/share")
    @ApiOperation("分享预览链接")
    @RbacPermission
    public ResultBean getPresignedObjectUrl(@RequestParam String objectName, @RequestParam Integer expires) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        return ResultBean.success("下载成功！",
                minIOService.getPresignedObjectUrl(bucketName, groupTenantId + "/" + companyTenantId + "/" + objectName, expires));
    }
    
    /*@ApiOperation("列出所有的桶")
    @RequestMapping(value = "/list/buckets", method = RequestMethod.GET)
    public ResultBean<List<BucketVO>> listBuckets() throws Exception {
        List<Bucket> buckets = minIOService.listBuckets();
        //List list = BeanCopyKits.copyListProperties(buckets, BucketVO.class);
        List<BucketVO> list = new ArrayList<>();
        for (int i = 0; i < buckets.size(); i++) {
            list.add(BucketVO.builder().bucketName(buckets.get(i).name()).build());
        }
        return ResultBean.success(list);
    }*/

    @ApiOperation("递归列出桶中指定目录的所有文件")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RbacPermission
    //public ResultBean listFiles(@RequestParam String bucket) throws Exception {
    public ResultBean listFiles() throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        //minIOService.isFolderExist(bucketName, groupTenantId + "/" + companyTenantId);
        //List<FileInfoVO> fileinfos = minIOService.listObjects(bucket);
        //List<FileInfoVO> fileinfos = minIOService.listObjects(bucket, groupTenantId + "/" + companyTenantId, true);
        List<FileInfoVO> fileinfos = minIOService.listObjects(bucketName, groupTenantId + "/" + companyTenantId, true);
        return ResultBean.success(fileinfos);
    }
    
    
    @ApiOperation("删除一个文件")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @RbacPermission
    public ResultBean deleteFile(@RequestParam String objectName) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        minIOService.deleteObject(bucketName, groupTenantId + "/" + companyTenantId + "/" + objectName);
        return ResultBean.success();
    }
    
    
    @ApiOperation("复制一个文件")
    @GetMapping("/copy")
    @RbacPermission
    //public ResultBean copyObject(@RequestParam String sourceBucket, @RequestParam String sourceObject, @RequestParam String targetBucket,@RequestParam String targetObject) throws Exception {
    public ResultBean copyObject(@RequestParam String sourceObject, @RequestParam String targetObject) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        minIOService.copyObject(bucketName, groupTenantId + "/" + companyTenantId + "/" + targetObject, bucketName,
                groupTenantId + "/" + companyTenantId + "/" + sourceObject);
        return ResultBean.success();
    }
    
    @GetMapping("/get")
    @ApiOperation("获取文件详细信息")
    @RbacPermission
    public ResultBean getObjectInfo(@RequestParam String objectName) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        return ResultBean.success(minIOService.getObjectInfo(bucketName, groupTenantId + "/" + companyTenantId + "/" + objectName));
    }
    @GetMapping("/getFileById")
    @ApiOperation("查询所有的文件")
    @RbacPermission
    public ResultBean getFileById(@RequestParam String id) {
        return fileInfoService.getFileById(id);
    }

}
