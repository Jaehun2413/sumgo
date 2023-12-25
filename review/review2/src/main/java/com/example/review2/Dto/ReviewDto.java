package com.example.review2.Dto;

import java.time.LocalDate;

public class ReviewDto {
    private int id;
    private int boardReviewNum;
    private String boardReviewSubject;
    private String boardReviewWriter;
    private String boardReviewRating;
    private String boardReviewContent;
    private LocalDate boardReviewRegdate;
    private int grp;
    private int seq;
    private int depth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardReviewNum() {
        return boardReviewNum;
    }

    public void setBoardReviewNum(int boardReviewNum) {
        this.boardReviewNum = boardReviewNum;
    }

    public String getBoardReviewSubject() {
        return boardReviewSubject;
    }

    public void setBoardReviewSubject(String boardReviewSubject) {
        this.boardReviewSubject = boardReviewSubject;
    }

    public String getBoardReviewWriter() {
        return boardReviewWriter;
    }

    public void setBoardReviewWriter(String boardReviewWriter) {
        this.boardReviewWriter = boardReviewWriter;
    }

    public String getBoardReviewRating() {
        return boardReviewRating;
    }

    public void setBoardReviewRating(String boardReviewRating) {
        this.boardReviewRating = boardReviewRating;
    }

    public String getBoardReviewContent() {
        return boardReviewContent;
    }

    public void setBoardReviewContent(String boardReviewContent) {
        this.boardReviewContent = boardReviewContent;
    }

    public LocalDate getBoardReviewRegdate() {
        return boardReviewRegdate;
    }

    public void setBoardReviewRegdate(LocalDate boardReviewRegdate) {
        this.boardReviewRegdate = boardReviewRegdate;
    }

    public int getGrp() {
        return grp;
    }

    public void setGrp(int grp) {
        this.grp = grp;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "id=" + id +
                ", boardReviewNum=" + boardReviewNum +
                ", boardReviewSubject='" + boardReviewSubject + '\'' +
                ", boardReviewWriter='" + boardReviewWriter + '\'' +
                ", boardReviewRateing='" + boardReviewRating + '\'' +
                ", boardReviewContent='" + boardReviewContent + '\'' +
                ", boardReviewRegdate=" + boardReviewRegdate +
                ", grp=" + grp +
                ", seq=" + seq +
                ", depth=" + depth +
                '}';
    }
}