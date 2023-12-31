package com.example.boardsample.main.board.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
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
    private Board board;

    protected Comment() {
    }

    public Comment(int commentCode, String commentContent, String postedDate, String deleteDate, Board board) {
        this.commentCode = commentCode;
        this.commentContent = commentContent;
        this.postedDate = postedDate;
        this.deleteDate = deleteDate;
        this.board = board;
    }

    public int getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(int commentCode) {
        this.commentCode = commentCode;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board boardCode) {
        this.board = boardCode;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentCode=" + commentCode +
                ", commentContent='" + commentContent + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", boardCode=" + board +
                '}';
    }
}
