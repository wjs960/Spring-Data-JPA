package com.example.boardsample.main.common;

public class PagingButton {
    private int currentPage;
    private int startPage;
    private int endPage;

    public PagingButton() {
    }

    public PagingButton(int currentPage, int startPage, int endPage) {
        this.currentPage = currentPage;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "PageingButton{" +
                "currentPage=" + currentPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                '}';
    }
}
