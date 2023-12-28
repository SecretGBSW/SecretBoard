package com.example.anonymousboard.board.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class CommentUpdateDto {
    private String pw;
    private String writer;
    private String title;
    private String contents;
}
