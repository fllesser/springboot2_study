package com.chowyijiu.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息: email={}, username={}, headImg.size={}, photos.length={}",
                email, username, headerImg.getSize(), photos.length);
        if (!headerImg.isEmpty()) {
            //保存到文件服务器, 或者对象存储服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("/Users/yijiuchow/Desktop/" + originalFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("/Users/yijiuchow/Desktop/photos/" + originalFilename));
                }
            }
        }
        return "main";
    }
}
