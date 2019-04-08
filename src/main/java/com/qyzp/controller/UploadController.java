package com.qyzp.controller;


import com.qyzp.bean.User;
import com.qyzp.service.CompanyService;
import com.qyzp.service.UserService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//上传文件
@RestController
@RequestMapping("/api/upload")
public class UploadController extends BaseApiController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    private static String baseDir = "D:/TomCat/qyzp_smsData/";//需要上传文件的基本路径
    private static String IMAGE_PATH = "/img/";
    private static String VIDEO_PATH = "/video/";
    @PostMapping("/saveAndThumbnail")//上传并压缩
    public Map<String,Object> saveFileAndThumbnail(Integer id,Integer roleType,@RequestParam MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return resp(405,"文件路径不存在");
        }
        String filePath = null;//原图
        String smallPicPath =  null;//缩略图
        /*if (roleType==3) {
            filePath = saveFile(file);// /img/xxx.jpg
            //Parm：
            //  正则表达式
            //      ^ 开头 ( .+任意字符串 以什么 )\\转义()$结尾
            //   $n 代表第n个括号括号里面的东西
            //
            smallPicPath = filePath.replaceAll("^(.+)\\.(jpeg|jpg|png)$","$1_small.$2");
       *//* //解析图片尺寸
        BufferedImage bufferedImage = Thumbnails.of(filePath)
                                                    .scale(1f)
                                                    .asBufferedImage();
        int width = bufferedImage.getWidth();
        int height  = bufferedImage.getHeight();*//*
            //限制最大长宽 最大质量
            Thumbnails.of(baseDir+filePath)//原图进行压缩
                    .size(480,480)
                    .outputQuality(0.8)
                    .toFile(baseDir+smallPicPath);
            Thumbnails.of(baseDir+filePath)//原图
                    .size(1000,50000)
                    .outputQuality(0.8)
                    .toFile(baseDir+filePath);
            String headPic = baseDir+filePath;//头像路径
            if (userService.updateHead(id,headPic)==0) {//调用用户模块的方法
                return resp(405,"修改头像失败");
            }
        }else if (roleType==4) {
            filePath = saveFile(file);// /img/xxx.jpg
            //Parm：
            //  正则表达式
            //      ^ 开头 ( .+任意字符串 以什么 )\\转义()$结尾
            //   $n 代表第n个括号括号里面的东西
            //
            smallPicPath = filePath.replaceAll("^(.+)\\.(jpeg|jpg|png)$","$1_small.$2");
       *//* //解析图片尺寸
        BufferedImage bufferedImage = Thumbnails.of(filePath)
                                                    .scale(1f)
                                                    .asBufferedImage();
        int width = bufferedImage.getWidth();
        int height  = bufferedImage.getHeight();*//*
            //限制最大长宽 最大质量
            Thumbnails.of(baseDir+filePath)//原图进行压缩
                    .size(480,480)
                    .outputQuality(0.8)
                    .toFile(baseDir+smallPicPath);
            Thumbnails.of(baseDir+filePath)//原图
                    .size(1000,50000)
                    .outputQuality(0.8)
                    .toFile(baseDir+filePath);
            String headPic = baseDir+filePath;//头像路径
            if (companyService.updateHead(id,headPic)==0) {//调用用户模块的方法
                return resp(405,"修改头像失败");
            }
        }*/
        filePath = saveFile(file);// /img/xxx.jpg
        //Parm：
        //  正则表达式
        //      ^ 开头 ( .+任意字符串 以什么 )\\转义()$结尾
        //   $n 代表第n个括号括号里面的东西
        //
        smallPicPath = filePath.replaceAll("^(.+)\\.(jpeg|jpg|png)$","$1_small.$2");
       /* //解析图片尺寸
        BufferedImage bufferedImage = Thumbnails.of(filePath)
                                                    .scale(1f)
                                                    .asBufferedImage();
        int width = bufferedImage.getWidth();
        int height  = bufferedImage.getHeight();*/
        //限制最大长宽 最大质量
        Thumbnails.of(baseDir+filePath)//原图进行压缩
                .size(480,480)
                .outputQuality(0.8)
                .toFile(baseDir+smallPicPath);
        Thumbnails.of(baseDir+filePath)//原图
                .size(1000,50000)
                .outputQuality(0.8)
                .toFile(baseDir+filePath);
        String headPic = baseDir+filePath;//头像路径
        Map<String,Object> map = new HashMap<>();
        map.put("pic",filePath);
        map.put("small_pic",smallPicPath);
        return resp(200,"修改成功",map);
    }

    private static String saveFile(MultipartFile file) throws IOException {
        File dirFile = new File(baseDir+IMAGE_PATH);
        if (!dirFile.exists()) { dirFile.mkdirs(); }
        int random  =  new Random(System.nanoTime()).nextInt(1000000);
        String oriName = file.getOriginalFilename();
        String fileSuffix = oriName.substring(oriName.lastIndexOf(".")+1,oriName.length());
        fileSuffix = fileSuffix.toLowerCase();//格式转换成小写
        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                +"_"+String.format("%06d",random)
                +"."+fileSuffix;
        File saveFile = new File(dirFile,fileName);
        file.transferTo(new File(dirFile,fileName));
        return IMAGE_PATH+fileName;//返回原图保存的绝对路径
    }

}
