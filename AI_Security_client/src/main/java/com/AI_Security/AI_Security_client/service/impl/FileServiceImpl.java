package com.AI_Security.AI_Security_client.service.impl;

import cn.hutool.core.date.DateTime;
import com.AI_Security.AI_Security_client.service.FileService;
import com.AI_Security.AI_Security_client.utils.ConstantPropertiesUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/07/31 14:40
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file) {
        COSClient cosClient = createCOSClient();
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String key;
        String dateTime = new DateTime().toString("yyyy/MM/dd");
        key = dateTime + "/" + UUID.randomUUID().toString().replaceAll("-", "") + file.getOriginalFilename();

        try {
            InputStream inputStream = file.getInputStream();
            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, objectMetadata);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            String url = "https://" + bucketName + "." + "cos" + "." + ConstantPropertiesUtil.END_POINT + ".myqcloud.com" + "/" + key;
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    COSClient createCOSClient() {
        String secretId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String secretKey = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region = new Region(ConstantPropertiesUtil.END_POINT);
        ClientConfig clientConfig = new ClientConfig(region);
        clientConfig.setHttpProtocol(HttpProtocol.https);
        return new COSClient(cred, clientConfig);
    }
}
