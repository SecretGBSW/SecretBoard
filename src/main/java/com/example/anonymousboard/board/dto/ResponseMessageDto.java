package com.example.anonymousboard.board.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseMessageDto {
    Map<String, String> status = new HashMap<>();
    private String state;
    private String message;

    public ResponseMessageDto(String state, String message) {
        status.put("status", state);
        status.put("message",message);
    }
}
