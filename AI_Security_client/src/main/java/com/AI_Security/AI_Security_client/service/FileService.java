package com.AI_Security.AI_Security_client.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/07/31 14:39
 */
public interface FileService {
    String upload(MultipartFile file);
}
