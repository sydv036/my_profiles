package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.CheckIsNullCommon;
import com.example.profiles.core.admin.service.IHandelImageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpHeaders;

@Service
public class HandelImageServiceImpl implements IHandelImageService {
    @Override
    public void downloadImage(String imageName) throws IOException {
        CheckIsNullCommon.isIdCheck(imageName);
        try {
            URL url = new URL(imageName);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            byte[] bytes = StreamUtils.copyToByteArray(inputStream);
//            String filePath = "C:/Downloads";
            File directory = new File("C:/Downloads/img");
            if (!directory.exists()) {
                directory.mkdirs(); // Tạo thư mục nếu chưa tồn tại
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(directory)) {
                fileOutputStream.write(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
