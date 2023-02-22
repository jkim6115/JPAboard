package com.example.board.service;

import com.example.board.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReplyServiceTests {

    @Autowired
    private ReplyService service;

    @Test
    public void testGetList() {
        Long bno = 100L;//데이터베이스에 존재하는 번호

        List<ReplyDTO> replyDTOList = service.getList(bno);

        replyDTOList.forEach(System.out::println);
    }
}
