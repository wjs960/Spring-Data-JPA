package com.example.boardsample.main.board.model.repository;

import com.example.boardsample.main.board.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepogitory extends JpaRepository<Board, Integer> {

    List<Board> findByTitleContaining(String searchWord);

    @Query(value = "SELECT b.board_code, b.title, b.posted_date, b.delete_date, b.view_count, b.board_content, b.user_id " +
            "FROM board b " +
            "WHERE b.title LIKE %:searchAll% or b.board_content LIKE %:searchAll% or b.user_id LIKE %:searchAll% ", nativeQuery = true)
    List<Board> findByBoardSearchAll(String searchAll);
}
