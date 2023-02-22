package com.example.board.repository;

import com.example.board.entity.Board;
import com.example.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository  extends JpaRepository<Reply, Long> {

    // 게시글 삭제시 댓글도 함께 삭제. 실제로 구현할 때는 보이지 않게만 처리
    @Modifying
    @Query("delete from Reply r where r.board.bno =:bno ")
    void deleteByBno(Long bno);
    List<Reply> getRepliesByBoardOrderByRno(Board board);
}
