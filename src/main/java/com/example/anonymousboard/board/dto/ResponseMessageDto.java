package com.example.anonymousboard.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ResponseMessageDto {
    private String status;
    private String message;

    public ResponseMessageDto(String state, String message) {
        this.status = state;
        this.message = message;
    }
}
