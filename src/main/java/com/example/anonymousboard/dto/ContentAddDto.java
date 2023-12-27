package com.example.anonymousboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentAddDto {
    private String title;
    private String content;
    private String user;
    @JsonIgnore
    private String pw;
}
