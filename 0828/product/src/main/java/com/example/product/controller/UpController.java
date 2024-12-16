package com.example.demo.updown;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UpController {

    @GetMapping("/form")
    public String uploadForm() {
        return  "/upload/form";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile f, String title) {
        //getOriginalFilename(): 원본 파일명 반환
        String fname = f.getOriginalFilename();
        File newf = new File("C:\\img\\" + fname);
        try {
            f.transferTo(newf);//업로드 파일을 newf에 복사
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("fname:" + fname);
        System.out.println("title:" + title);
        return "redirect:/index";
    }
}