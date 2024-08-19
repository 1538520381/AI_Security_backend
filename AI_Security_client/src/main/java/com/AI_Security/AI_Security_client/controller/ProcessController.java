package com.AI_Security.AI_Security_client.controller;

import com.AI_Security.AI_Security_client.entity.result.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
@CrossOrigin
public class ProcessController {
    @GetMapping("/train")
    public R preprocess(@RequestParam("trainId") String trainId, @RequestParam("idString") String idString) {
        // 根据trainId查出本次上传的数据的url
//        Train train = trainService.getById(trainId);
//        String dataUrl = train.getDataUrl();
//        String retInfo = client.localTrain(idString, dataUrl);
//        String url = fileService.uploadSimple(retInfo);
//        train.setMethod(idString); // 保存此次训练的方法
//        train.setPreprocessData(url);
//        trainService.updateById(train);
        String url = "";
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return R.success().put("retInfo", url);  // 返回了预处理完后的数据集的url
    }
}
