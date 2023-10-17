package com.example.boardsample.main.board.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "comment_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentCode;
    @Column(name = "comment_content",columnDefinition = "TEXT", nullable = false)
    private String commentContent;
    @Column(name = "posted_date")
    private String postedDate;
    @Column(name = "delete_date")
    private String deleteDate;
    @ManyToOne
    @JoinColumn(name = "board_code")
    private Board boardCode;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

}
