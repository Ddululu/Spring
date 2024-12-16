package com.example.demo.imgboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.rep.ImgrepDto;
import com.example.demo.rep.ImgrepService;

@Controller
@RequestMapping("/imgboard")
public class ImgboardController {
	@Autowired
	private ImgboardService service;
	
	@Autowired
	private ImgrepService repservice;

	@Value("${spring.servlet.multipart.location}")
	private String path; // C:/img/

	private String dirName = "imgboard/";

	@GetMapping("/list")
	public void list(ModelMap map) {
		ArrayList<ImgboardDto> list = service.getAll();
		for(ImgboardDto d:list) {
			d.setReps(repservice.getByParent(d.getNum()));
		}
		map.addAttribute("list", list);
	}

	@GetMapping("/add")
	public void addForm() {
	}

	@PostMapping("/add")
	public String add(ImgboardDto dto) {
		ImgboardDto d = service.save(dto);// insert 동작 / dto:작성자, title, content
		// d: num, writer, title, content, wdate
		String oname = dto.getF().getOriginalFilename();// a.jpg
		String f1 = oname.substring(oname.lastIndexOf("."));// f1:.jpg
		// 업로드 파일명을 글번호.확장자
		String fname = d.getNum() + f1;
		File newFile = new File(path + dirName + fname);
		try {
			dto.getF().transferTo(newFile);// 업로드 파일 복사
			d.setFname(newFile.getName());// 생성한 파일의 이름을 객체 d의 fname에 저장
			service.save(d);// update 동작. fname값 수정
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/imgboard/list";
	}

	@GetMapping("/read-img")
	public ResponseEntity<byte[]> read_img(String fname) {
		ResponseEntity<byte[]> result = null;
		File f = new File(path + dirName + fname);
		HttpHeaders header = new HttpHeaders(); // import org.springframework.http.HttpHeaders;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@PostMapping("/edit")
	public String edit(ImgboardDto dto) {
		ImgboardDto d = service.getBoard(dto.getNum());
		d.setTitle(dto.getTitle());
		d.setContent(dto.getContent());
		service.save(d);
		return "redirect:/imgboard/list";
	}

	@GetMapping("/del")
	public String del(int num) {
		ImgboardDto d = service.getBoard(num);
		String fname = d.getFname();
		File f = new File(path + dirName + fname);
		f.delete();
		service.delBoard(num);
		return "redirect:/imgboard/list";
	}
	
	@PostMapping("/addrep")
	@ResponseBody
	public Map addrep(ImgrepDto dto) {
		repservice.save(dto);
		Map map = new HashMap();
		map.put("reps", repservice.getByParent(dto.getParent().getNum()));
		return map;
	}
	
	@GetMapping("/repsbywriter")
	@ResponseBody
	public String repsbywriter(int num) {
		ArrayList<ImgrepDto> list = repservice.getByNumWriter(num);
		return list.toString();
	}
	
	@GetMapping("/editcnt")
	public String editcnt(int num) {
		service.editCnt(num);
		return "redirect:/imgboard/list";
	}
}







