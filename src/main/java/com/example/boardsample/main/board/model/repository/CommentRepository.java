package com.example.boardsample.main.board.model.repository;

import com.example.boardsample.main.board.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query(value = "SELECT comment_code,board_code,comment_content,delete_date,posted_date " +
            "FROM comment " +
            "WHERE board_code = :boardCode " +
            "ORDER BY posted_date DESC ", nativeQuery = true)
    List<Comment> findAllCommnetByCode(int boardCode);

}
