package com.AI_Security.AI_Security_client.controller;

import cn.hutool.core.io.resource.ClassPathResource;
import com.AI_Security.AI_Security_client.entity.result.R;
import com.AI_Security.AI_Security_client.grpc.gRPCServer;
import com.AI_Security.AI_Security_client.grpc2.gRPCServer2;
import com.AI_Security.AI_Security_client.utils.InformationUtil;
import com.AI_Security.AI_Security_client.utils.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Persolute
 * @version 1.0
 * @description Common Controller
 * @email 1538520381@qq.com
 * @date 2024/05/05 17:21
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);


    @GetMapping("/information")
    public R information() throws IOException {
        return R.success().put("information", InformationUtil.get());
    }

    @PostMapping("/file")
    public R fun(HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        int num = 6;
        map.put("d1", "2024-7-29");
        map.put("d2", "192.168.1.1");
        map.put("d3", num);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Map<String, Object> map0 = new HashMap<>();
            map0.put("d4", "CVE编号-" + i);
            map0.put("d5", "漏洞名称-" + i);
            map0.put("d6", "厂商-" + i);
            map0.put("d7", "漏洞等级-" + i);
            map0.put("d8", "漏洞类型-" + i);
            map0.put("d9", "漏洞描述-" + i);
            map0.put("d10", "漏洞评分-" + i);
            map0.put("d11", "修复补丁信息-" + i);
            list.add(map0);
        }
        map.put("list", list);

        String basePath = "document";
        String templatePath = basePath + "\\template";

        String fileName = templatePath + "\\word\\document.xml";
        String ftlPath = basePath;
        String ftlName = "document.ftl";
        String needZipPath = templatePath;

        WordUtils.generateWord(map, fileName, ftlPath, ftlName);
        WordUtils.zipFileTree(new File(new ClassPathResource(needZipPath).getUrl().getFile()), "zip", response);
        return R.success();
    }

    @GetMapping("/train")
    private R detecd() throws IOException, ParseException {
        List<Map<String, String>> detect = gRPCServer.getDetect();
        return R.success().put("detect", detect);
    }

    @GetMapping("/detect/file")
    private void getDetectFile(HttpServletResponse httpServletResponse) {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\detect.csv");
            ServletOutputStream outputStream = httpServletResponse.getOutputStream();
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/result/{userId}")
    private R getResult(@PathVariable("userId") Integer userId) {
        if (userId != 1) {
            return R.success().put("result", gRPCServer.result).put("result0", gRPCServer.result0);
        } else {
            return R.success().put("result", gRPCServer2.result).put("result0", gRPCServer2.result0);
        }
    }
}
