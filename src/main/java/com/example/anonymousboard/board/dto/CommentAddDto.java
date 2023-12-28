package com.example.anonymousboard.board.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CommentAddDto {
    private String pw;
    private String writer;
    private String title;
    private String content;
}
