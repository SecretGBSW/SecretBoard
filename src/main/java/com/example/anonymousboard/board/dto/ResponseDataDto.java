package com.example.anonymousboard.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ResponseDataDto<Data> {
    Map<String, String> status = new HashMap<>();
    private String state;
    private String message;
    private Data data;

    public ResponseDataDto(String state, String message, Data data) {
        status.put("status", state);
        status.put("message",message);
        this.data = data;
    }
}