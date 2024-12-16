package com.example.dataroom.board;

import com.example.dataroom.member.MemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*") // 모든 IP에서 Rest API 요청을 받는다 -> 원래는 서버와 소통하는 용도기 때문에 지정된 ip만 허용
@RequestMapping("/api/board")
public class BoardRestController {
    private BoardService service;
    @Autowired
    public BoardRestController(BoardService service) { this.service = service; }

    // getAll() 모든 보드 목록을 가져오기
    @GetMapping("/")
    public List<BoardDto> getAll(){
        return service.getAll();
    }
    // saveBoard() 보드를 추가하기
    @PostMapping("/add")
    public void add(BoardDto dto){
        service.saveBoard(dto);
    }
    // getBoard(num) 보드 번호로 보드 가져오기
    @GetMapping("/get")
    public BoardDto get(@RequestParam("num") int num){
        return service.getBoard(num);
    }
    // getBoard(num) -> saveBoard()로 보드 수정하기
    @GetMapping("/edit")
    public void getEdit(@RequestParam("num") int num, BoardDto dto){
        BoardDto temp = service.getBoard(num);
        temp.setTitle(dto.getTitle());
        temp.setContent(dto.getContent());
        service.saveBoard(temp);
    }
    // delBoard(num) -> 보드 번호로 보드 삭제하기
    @GetMapping("/del")
    public void del(@RequestParam("num") int num){
        service.delBoard(num);
    }
    // getByTitle(Title) -> 타이틀로 보드 목록 가져오기
    // getByWriter(writer) -> 작성자로 보드 목록 가져오기

}
