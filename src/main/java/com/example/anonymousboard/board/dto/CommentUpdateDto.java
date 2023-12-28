package com.example.anonymousboard.board.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class CommentUpdateDto {
    @JsonIgnore
    private String pw;
}
