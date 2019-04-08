package com.qyzp.handler.impl;

import com.qyzp.controller.BaseApiController;
import com.qyzp.handler.DownloadFileHandler;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImgDownloadFileHandler extends BaseApiController implements DownloadFileHandler {
    @Override
    public Map<String, Object> saveFile(MultipartFile file) throws IOException {
        System.out.println("file_name"+file.getOriginalFilename());//输出获得的文件名称
        String uploadFilePath = System.getProperty("catalina.home")+"\\qyzp_smsData\\qyzp_smsPicture";//文件上传的路径
        System.out.println(uploadFilePath);
        String dirPath = "D:/TomCat/qyzp_smsData/qyzp_smsPicture";//获取路径
        String filePath = "/server/firstDemo"+"/download/img"+"123.png";
        File dir = new File(dirPath);
        if(!dir.exists()) {//如果这个文件夹不存在
            dir.mkdirs();//生成路径(带s的方法将dirpath完整路径创建,不带s的方法只创建路径最后一个文件夹)
        }
        String oriName= file.getOriginalFilename();//原本文件名
        //保存文件名需要获取系统当前时间+文件格式 (系统时间撮.格式)
        String saveName = System.currentTimeMillis()+oriName.substring(oriName.lastIndexOf("."),oriName.length());
        File saveFile = new File(saveName);
        file.transferTo(saveFile);//上传文件
        Map<String,Object> map = new HashMap<>();
        map.put("pic",dirPath+"/"+saveName);
        return map;
    }

}
