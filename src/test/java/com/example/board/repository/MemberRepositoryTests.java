package com.example.board.repository;

import com.example.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMembers() {
        IntStream.rangeClosed(1, 100).forEach((i) -> {
            Member member = Member.builder()
                    .email("r" + i + "@aaa.com")
                    .pwd("1111")
                    .nickname("reviewer" + i)
                    .build();
            memberRepository.save(member);
        });
    }

    @Test
    public void testDeleteMember() {
        Long mid = 1L;
        Member member = Member.builder().mid(mid).build();
        memberRepository.deleteById(mid);
        reviewRepository.deleteByMember(member);
    }
}
