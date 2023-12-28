package com.example.anonymousboard.board.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentGetDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    @JsonIgnore
    private String pw;
}
