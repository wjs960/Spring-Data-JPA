package com.example.boardsample.main.board.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "board")
public class Board {

    @Id
    @Column(name = "board_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardCode; //게시글코드
    @Column(name = "title")
    private String title; // 제목
    @Column(name = "posted_date")
    private String postedDate; // 게시물 작성일시
    @Column(name = "delete_date")
    private String deleteDate; // 게시물 삭제일시
    @Column(name = "view_count")
    private int viewCount; // 게시물 조회 수
    @Column(name = "board_content")
    private String boardContent; // 게시글 내용
    @Column(name = "user_id")
    private String userId; // 유저 아이디
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Comment> commentList;

    protected Board() {}

    public Board(int boardCode, String title, String postedDate, String deleteDate, int viewCount, String boardContent,String userId) {
        this.boardCode = boardCode;
        this.title = title;
        this.postedDate = postedDate;
        this.deleteDate = deleteDate;
        this.viewCount = viewCount;
        this.boardContent = boardContent;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardCode=" + boardCode +
                ", title='" + title + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", viewCount=" + viewCount +
                ", boardContent='" + boardContent + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
