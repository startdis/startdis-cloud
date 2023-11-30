package com.startdis.comm.minio.service;

import com.startdis.comm.minio.domian.FileInfoVO;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author Startdis
 * @email startdis@njydsz.com
 * @desc MinIOService
 */
@Slf4j
@Component
public class MinIOService {
    
    @Resource
    private MinioClient minioClient;
    
    public static void main(String[] args) throws Exception {
        MinioClient minioClient = MinioClient.builder().endpoint("/http://1.13.21.54:9000").credentials("ydsz", "ydsz1020").build();
        /*MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("https://play.min.io")
                        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                        .build();*/
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("dianjiu").build());
        if (found) {
            System.out.println("dianjiu bucket name exists");
        } else {
            System.out.println("dianjiu bucket name does not exist");
        }
    }
    
    /******************************  Operate Bucket Start  ******************************/
    
    /**
     * 启动SpringBoot容器的时候初始化Bucket 如果没有Bucket则创建
     *
     * @throws Exception
     */
    public void createBucket(String bucketName) throws Exception {
        if (!bucketExists(bucketName)) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }
    
    /**
     * 判断Bucket是否存在，true：存在，false：不存在
     *
     * @return
     * @throws Exception
     */
    public boolean bucketExists(String bucketName) throws Exception {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }
    
    
    /**
     * 获得Bucket的策略
     *
     * @param bucketName
     * @return
     * @throws Exception
     */
    public String getBucketPolicy(String bucketName) throws Exception {
        return minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().bucket(bucketName).build());
    }
    
    
    /**
     * 获得所有Bucket列表
     *
     * @return
     * @throws Exception
     */
    public List<Bucket> listBuckets() throws Exception {
        return minioClient.listBuckets();
    }
    
    /**
     * 根据bucketName获取其相关信息
     *
     * @param bucketName
     * @return
     * @throws Exception
     */
    public Optional<Bucket> getBucket(String bucketName) throws Exception {
        return listBuckets().stream().filter(b -> b.name().equals(bucketName)).findFirst();
    }
    
    /**
     * 根据bucketName删除Bucket，true：删除成功； false：删除失败，文件或已不存在
     *
     * @param bucketName
     * @throws Exception
     */
    public void deleteBucket(String bucketName) throws Exception {
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }
    
    /******************************  Operate Bucket End  ******************************/
    
    /******************************  Operate Files Start  ******************************/
    
    /**
     * 创建文件夹或目录
     *
     * @param bucketName 存储桶
     * @param objectName 目录路径
     */
    public ObjectWriteResponse createDir(String bucketName, String objectName) throws Exception {
        return minioClient.putObject(
                PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(new ByteArrayInputStream(new byte[] {}), 0, -1).build());
    }
    
    /**
     * 判断文件是否存在
     *
     * @param bucketName 存储桶
     * @param objectName 文件名
     * @return
     */
    public boolean isObjectExist(String bucketName, String objectName) {
        boolean exist = true;
        try {
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            log.error("[Minio工具类]>>>> 判断文件是否存在, 异常：", e);
            exist = false;
        }
        return exist;
    }
    
    /**
     * 判断文件夹是否存在
     *
     * @param bucketName 存储桶
     * @param objectName 文件夹名称
     * @return
     */
    public boolean isFolderExist(String bucketName, String objectName) {
        boolean exist = false;
        try {
            Iterable<Result<Item>> results =
                    minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).prefix(objectName).recursive(false).build());
            for (Result<Item> result : results) {
                Item item = result.get();
                if (item.isDir() && objectName.equals(item.objectName())) {
                    exist = true;
                }
            }
        } catch (Exception e) {
            log.error("[Minio工具类]>>>> 判断文件夹是否存在，异常：", e);
            exist = false;
        }
        return exist;
    }
    
    /**
     * 获取minio中所有的文件
     *
     * @Param: []
     * @return: java.util.List<boot.spring.domain.FileInfo>
     * @Author: dianjiu
     * @Date: 2021/11/15
     */
    public List<FileInfoVO> listAllFile() throws Exception {
        List<Bucket> list = this.listBuckets();
        List<FileInfoVO> fileInfos = new ArrayList<>();
        for (Bucket bucket : list) {
            fileInfos.addAll(this.listObjects(bucket.name()));
        }
        return fileInfos;
    }
    
    
    /**
     * 根据文件前置查询文件
     *
     * @param bucketName 存储桶
     * @param prefix     前缀
     * @param recursive  是否使用递归查询
     * @return MinioItem 列表
     * @throws Exception
     */
    public List<Item> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive) throws Exception {
        List<Item> list = new ArrayList<>();
        Iterable<Result<Item>> objectsIterator =
                minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).prefix(prefix).recursive(recursive).build());
        if (objectsIterator != null) {
            for (Result<Item> o : objectsIterator) {
                Item item = o.get();
                list.add(item);
            }
        }
        return list;
    }
    
    /**
     * 获取路径下文件列表
     *
     * @param bucketName 存储桶
     * @param prefix     文件名称
     * @param recursive  是否递归查找，false：模拟文件夹结构查找
     * @return 二进制流
     */
    public List<FileInfoVO> listObjects(String bucketName, String prefix, boolean recursive) {
        List<FileInfoVO> infos = new ArrayList<>();
        Iterable<Result<Item>> results =
                minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).prefix(prefix).recursive(recursive).build());
        results.forEach(r -> {
            FileInfoVO info = new FileInfoVO();
            try {
                Item item = r.get();
                info.setFilename(item.objectName());
                info.setDirectory(item.isDir());
                infos.add(info);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return infos;
    }
    
    /**
     * 递归查找指定桶中的所有文件和目录
     *
     * @param bucketName 存储桶
     */
    public List<FileInfoVO> listObjects(String bucketName) {
        List<FileInfoVO> infos = new ArrayList<>();
        Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).recursive(true).build());
        results.forEach(r -> {
            FileInfoVO info = new FileInfoVO();
            try {
                Item item = r.get();
                info.setFilename(item.objectName());
                info.setDirectory(item.isDir());
                infos.add(info);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return infos;
    }
    
    /**
     * 使用MultipartFile进行文件上传
     *
     * @param bucketName  存储桶
     * @param file        文件名
     * @param objectName  对象名
     * @param contentType 类型
     * @return
     * @throws Exception
     */
    public ObjectWriteResponse uploadFile(String bucketName, MultipartFile file, String objectName, String contentType) throws Exception {
        InputStream inputStream = file.getInputStream();
        return minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName).contentType(contentType)
                .stream(inputStream, inputStream.available(), -1).build());
    }
    
    /**
     * 上传本地文件
     *
     * @param bucketName 存储桶
     * @param objectName 对象名称
     * @param fileName   本地文件路径
     */
    public ObjectWriteResponse uploadFile(String bucketName, String objectName, String fileName) throws Exception {
        return minioClient.uploadObject(UploadObjectArgs.builder().bucket(bucketName).object(objectName).filename(fileName).build());
    }
    
    /**
     * 通过流上传文件
     *
     * @param bucketName  存储桶
     * @param objectName  文件对象
     * @param inputStream 文件流
     */
    public ObjectWriteResponse uploadFile(String bucketName, String objectName, InputStream inputStream) throws Exception {
        return minioClient.putObject(
                PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(inputStream, inputStream.available(), -1).build());
    }
    
    /**
     * 获取文件流
     *
     * @param bucketName 存储桶
     * @param objectName 文件名
     * @return 二进制流
     */
    public InputStream download(String bucketName, String objectName) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }
    
    /**
     * 断点下载
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     * @param offset     起始字节的位置
     * @param length     要读取的长度
     * @return 二进制流
     */
    public InputStream download(String bucketName, String objectName, long offset, long length) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).offset(offset).length(length).build());
    }
    
    /**
     * 获取文件信息, 如果抛出异常则说明文件不存在
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     */
    public String getObjectInfo(String bucketName, String objectName) throws Exception {
        return minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(objectName).build()).toString();
    }
    
    /**
     * 拷贝文件
     *
     * @param bucketName    存储桶
     * @param objectName    文件名
     * @param srcBucketName 目标存储桶
     * @param srcObjectName 目标文件名
     */
    public ObjectWriteResponse copyObject(String bucketName, String objectName, String srcBucketName, String srcObjectName) throws Exception {
        return minioClient.copyObject(
                CopyObjectArgs.builder().source(CopySource.builder().bucket(bucketName).object(objectName).build()).bucket(srcBucketName)
                        .object(srcObjectName).build());
    }
    
    /**
     * 删除文件
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     */
    public void deleteObject(String bucketName, String objectName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }
    
    /**
     * 批量删除文件
     *
     * @param bucketName 存储桶
     * @param keys       需要删除的文件列表
     * @return
     */
    public void deleteObjects(String bucketName, List<String> keys) {
        List<DeleteObject> objects = new LinkedList<>();
        keys.forEach(s -> {
            objects.add(new DeleteObject(s));
            try {
                deleteObject(bucketName, s);
            } catch (Exception e) {
                log.error("[Minio工具类]>>>> 批量删除文件，异常：", e);
            }
        });
    }
    
    /**
     * 获取文件外链
     *
     * @param bucketName 存储桶
     * @param objectName 文件名
     * @param expires    过期时间 <=7 秒 （外链有效时间（单位：秒））
     * @return url
     * @throws Exception
     */
    public String getPresignedObjectUrl(String bucketName, String objectName, Integer expires) throws Exception {
        GetPresignedObjectUrlArgs args =
                GetPresignedObjectUrlArgs.builder().method(Method.GET).expiry(expires).bucket(bucketName).object(objectName).build();
        return minioClient.getPresignedObjectUrl(args);
    }
    
    /**
     * 获得文件外链
     *
     * @param bucketName
     * @param objectName
     * @return url
     * @throws Exception
     */
    public String getPresignedObjectUrl(String bucketName, String objectName) throws Exception {
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder().bucket(bucketName).object(objectName).method(Method.GET).build();
        return minioClient.getPresignedObjectUrl(args);
    }
    
    /**
     * 将URLDecoder编码转成UTF8
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getUtf8ByURLDecoder(String str) throws UnsupportedEncodingException {
        String url = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        return URLDecoder.decode(url, "UTF-8");
    }
    
    /******************************  Operate Files End  ******************************/
}
