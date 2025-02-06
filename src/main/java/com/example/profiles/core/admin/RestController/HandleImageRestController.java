package com.example.profiles.core.admin.RestController;

import com.example.profiles.core.admin.service.IHandelImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class HandleImageRestController {
    private final IHandelImageService handelImageService;

    @GetMapping("/download/img")
    public ResponseEntity<?> downloadImage(@RequestParam("url") String url) throws IOException {
        handelImageService.downloadImage(url);
        return ResponseEntity.ok("OKE");
    }
}
