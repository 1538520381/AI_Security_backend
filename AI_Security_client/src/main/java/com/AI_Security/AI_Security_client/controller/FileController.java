package com.AI_Security.AI_Security_client.controller;

import com.AI_Security.AI_Security_client.entity.po.Train;
import com.AI_Security.AI_Security_client.entity.result.R;
import com.AI_Security.AI_Security_client.grpc1.Response;
import com.AI_Security.AI_Security_client.grpc1.gRPCServer1;
import com.AI_Security.AI_Security_client.service.FileService;
import com.AI_Security.AI_Security_client.service.TrainService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/07/31 14:34
 */
@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    private TrainService trainService;


    /*
     * @author Persolute
     * @version 1.0
     * @description 数据集上传
     * @email 1538520381@qq.com
     * @date 2024/7/31 下午4:33
     */
    @PostMapping("/upload")
    public R uploadFile(@RequestParam("user_id") String user_id, @RequestParam("data_name") String data_name, @RequestBody MultipartFile file) {
        String url = fileService.upload(file);
        Train train = new Train();
        train.setUserId(user_id);
        train.setDataUrl(url);
        train.setDataName(data_name);
        trainService.save(train);
        return R.success().put("url", url).put("trainId", train.getId());
    }

    @GetMapping("/showDetail1")
    public R showDetail1(@RequestParam("url") String url, @RequestParam("type") String type) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Response response = gRPCServer1.dataInfo(url, type);
        LambdaQueryWrapper<Train> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Train::getDataUrl, url);
        Train train = trainService.getOne(lambdaQueryWrapper);
        train.setDataAnalysis(response.getDatainfoRet());
        trainService.updateById(train);
        List<Object> list = new ArrayList<>();
        for (Response.Arr arr : response.getArrList()) {
            list.add(arr.getValuesList());
        }
        return R.success()
                .put("reply", response.getDatainfoRet())
                .put("n", response.getN())
                .put("n2", response.getN2())
                .put("n3", response.getN3())
                .put("x1", response.getX1List())
                .put("y1", response.getY1List())
                .put("r1", response.getR1())
                .put("r2", response.getR2())
                .put("r3", response.getR3())
                .put("r21", response.getR21())
                .put("r22", response.getR22())
                .put("c1", response.getC1())
                .put("c2", response.getC2())
                .put("columns", response.getColumnsList())
                .put("arr", list);
    }

    @GetMapping("/showDetail2")
    public R showDetail2(@RequestParam("url") String url, @RequestParam("type") String type) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Response response = gRPCServer1.dataInfo(url, type);
        List<Object> list = new ArrayList<>();
        for (Response.Arr arr : response.getArrList()) {
            list.add(arr.getValuesList());
        }
        return R.success()
                .put("reply", response.getDatainfoRet())
                .put("n", response.getN())
                .put("n2", response.getN2())
                .put("n3", response.getN3())
                .put("x1", response.getX1List())
                .put("y1", response.getY1List())
                .put("r1", response.getR1())
                .put("r2", response.getR2())
                .put("r3", response.getR3())
                .put("r21", response.getR21())
                .put("r22", response.getR22())
                .put("c1", response.getC1())
                .put("c2", response.getC2())
                .put("columns", response.getColumnsList())
                .put("arr", list);
    }

    @GetMapping("/getModelUrlByTrainId")
    public R getModelUrlByTrainId(@RequestParam("trainId") Long trainId) {
        Train train = trainService.getById(trainId);
        return R.success().put("preprocessDataUrl", train.getPreprocessData());
    }
}
