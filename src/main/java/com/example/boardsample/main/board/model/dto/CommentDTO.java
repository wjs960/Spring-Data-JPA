package com.example.boardsample.main.board.model.dto;

import com.example.boardsample.main.board.model.entity.Board;

public class CommentDTO {
    private int commentCode;
    private String commentContent;
    private String postedDate;
    private String deleteDate;
    private Board boardCode;

    public CommentDTO() {
    }

    public CommentDTO(int commentCode, String commentContent, String postedDate, String deleteDate, Board boardCode) {
        this.commentCode = commentCode;
        this.commentContent = commentContent;
        this.postedDate = postedDate;
        this.deleteDate = deleteDate;
        this.boardCode = boardCode;
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

    public Board getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(Board boardCode) {
        this.boardCode = boardCode;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "commentCode=" + commentCode +
                ", commentContent='" + commentContent + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", boardCode=" + boardCode +
                '}';
    }
}
