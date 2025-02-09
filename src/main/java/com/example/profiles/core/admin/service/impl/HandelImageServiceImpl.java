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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class HandelImageServiceImpl implements IHandelImageService {
    @Override
    public void downloadImage(String imageName) throws IOException {
        CheckIsNullCommon.isIdCheck(imageName);
        try {
            imageName = imageName.replaceAll("\"", "");
            String urlImg = imageName.split("@@@@")[1];
            String osName = imageName.split("@@@@")[0];
            URL url = new URL(urlImg);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            File directory;
            if (osName.equals("DESKTOP")) {
                directory = new File(System.getProperty("user.home"), "/Downloads");
            } else {
                directory = new File(System.getProperty("user.home"), "/Downloads");
            }
            if (!directory.exists()) {
                directory.mkdirs();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            File imageFile = new File(directory, "downloaded_image_" + simpleDateFormat.format(new Timestamp(System.currentTimeMillis())) + ".jpg");
            FileOutputStream outputStream = new FileOutputStream(imageFile); // Sử dụng imageFile ở đây

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();

        } catch (MalformedURLException e) {
            System.out.println("URL không hợp lệ: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi khi tải ảnh: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }
}
