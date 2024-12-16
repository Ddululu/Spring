package com.example.demo.up;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/up")
public class UpController {
	@Value("${spring.servlet.multipart.location}")
	private String path;

	@GetMapping("")
	public String uploadForm() {
		return "up/form";
	}

	@PostMapping("")
	public String upload(MultipartFile f, String title) {
		String fname = f.getOriginalFilename();// 원본 파일명
		File newFile = new File(path + fname);
		try {
			f.transferTo(newFile);// 업로드 파일 복사
			System.out.println("file:" + newFile.getAbsolutePath());
			System.out.println("title:" + title);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/up/list";
	}

	@GetMapping("/list")
	public void list(ModelMap map) {
		File dir = new File(path);
		String[] files = dir.list();
		map.addAttribute("files", files);
	}

	@GetMapping("/read-img")
	public ResponseEntity<byte[]> read_img(String fname) {
		ResponseEntity<byte[]> result = null;
		File f = new File(path + fname);
		HttpHeaders header = new HttpHeaders(); //import org.springframework.http.HttpHeaders;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<byte[]>(
						FileCopyUtils.copyToByteArray(f),header, HttpStatus.OK
					);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}




