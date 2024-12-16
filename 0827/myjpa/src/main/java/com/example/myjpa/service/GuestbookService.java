package com.example.myjpa.service;

import com.example.myjpa.Entity.GuestbookEntity;
import com.example.myjpa.repository.GuestbookRepository;
import com.example.myjpa.dto.GuestbookDTO;
import com.example.myjpa.vo.Guestbook;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GuestbookService {

    private GuestbookRepository guestbookRepository;
    @Autowired
    public GuestbookService(GuestbookRepository daoguestbookRepository) {
        this.guestbookRepository = daoguestbookRepository;
    }

    // Create (DTO -> Entity -> DB)
    public void addBook(GuestbookDTO DTO) {
        GuestbookEntity entity = new GuestbookEntity(
                DTO.getWriter(),
                DTO.getPwd(),
                DTO.getContent()
        );
        guestbookRepository.save(entity);
    }

    // Read All (Entity -> VO -> List of VO)
    public ArrayList<Guestbook> getAll() {
       List<GuestbookEntity> entities = guestbookRepository.findAll();
        ArrayList<Guestbook> guestbooks = new ArrayList<>();

        for (GuestbookEntity entity : entities) {
            guestbooks.add(new Guestbook(
                    entity.getNum(),
                    entity.getWriter(),
                    entity.getWdate(),
                    entity.getPwd(),
                    entity.getContent()
            ));
        }

        return guestbooks;
    }

    // Read One (Entity -> VO)
    public Guestbook getBook(int num) {
        GuestbookEntity entity = guestbookRepository.findById(num)
                .orElseThrow(() -> new EntityNotFoundException("Guestbook entry not found"));
        return new Guestbook(
                entity.getNum(),
                entity.getWriter(),
                entity.getWdate(),
                entity.getPwd(),
                entity.getContent()
        );
    }

    // Read all by Writer (List<Entity>-> ArrayList<VO>)
    public ArrayList<Guestbook> getByWriter(String writer) {
        List<GuestbookEntity> entities = guestbookRepository.findByWriter(writer);
        ArrayList<Guestbook> guestbooks = new ArrayList<>();
        if(entities.isEmpty()) new EntityNotFoundException("작성자로 조회 실패");
        else {
            for (GuestbookEntity entity : entities) {
                guestbooks.add(new Guestbook(
                        entity.getNum(),
                        entity.getWriter(),
                        entity.getWdate(),
                        entity.getPwd(),
                        entity.getContent()));
            }
        }
        return guestbooks;
    }

    // Update (DTO -> Entity -> DB)
    public void updateBook(int num, GuestbookDTO DTO) {
        GuestbookEntity entity = guestbookRepository
                .findById(num)
                .orElseThrow(() -> new EntityNotFoundException("Guestbook entry not found"));
        entity.setWriter(DTO.getWriter());
        entity.setPwd(DTO.getPwd());
        entity.setContent(DTO.getContent());
        guestbookRepository.save(entity);
    }

    // Delete (Entity)
    public void deleteBook(int num) {
        guestbookRepository.deleteById(num);
    }
}