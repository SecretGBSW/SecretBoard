package com.example.anonymousboard.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ResponseMessageDto {
    Map<String, String> status = new HashMap<>();
    private String state;
    private String message;

    public ResponseMessageDto(String state, String message) {
        status.put("status", state);
        status.put("message",message);
    }
}
