package com.example.demo.updown;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UpController {

    @GetMapping("/form")
    public void uploadForm() {
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> upload(MultipartFile f, String title) {
        //getOriginalFilename(): 원본 파일명 반환
        String fname = f.getOriginalFilename();
        File newf = new File("D:\\img\\" + fname);
        try {
            f.transferTo(newf);
            return ResponseEntity.ok("File uploaded successfully: " + fname);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public void list(Model m) {
        //C:\\img\\ 폴더의 파일 목록을 읽어서 m에 담아서 list.html 파일명 목록 출력
        File dir = new File("C:\\img\\");
        String[] files = dir.list();//파일 목록
        m.addAttribute("files", files);
    }
}
