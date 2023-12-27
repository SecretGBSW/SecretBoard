package com.example.anonymousboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentUpdateDto {
    private String title;
    private String content;
    private String user;
}
