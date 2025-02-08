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
            URL url = new URL(imageName.replaceAll("\"", ""));
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();

            File directory = new File(System.getProperty("user.home"), "/Downloads");
            // **Đảm bảo thư mục tồn tại, nếu không thì tạo mới**
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File imageFile = new File(directory, "downloaded_image.jpg");
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
