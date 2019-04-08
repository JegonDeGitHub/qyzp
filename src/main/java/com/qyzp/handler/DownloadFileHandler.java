package com.qyzp.handler;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface DownloadFileHandler {
    //上传文件
    Map<String,Object> saveFile(MultipartFile file) throws IOException;
}
