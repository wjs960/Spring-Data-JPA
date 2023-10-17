package com.example.boardsample.main.board.model.repository;

import com.example.boardsample.main.board.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
