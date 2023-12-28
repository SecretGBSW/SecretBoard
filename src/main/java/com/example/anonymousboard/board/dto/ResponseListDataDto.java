package com.example.anonymousboard.board.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ResponseListDataDto<Data> {
    Map<String, String> status = new HashMap<>();
    private String state;
    private String message;
    private List<Data> data;

    public ResponseListDataDto(String state, String message, List<Data> data) {
        status.put("status", state);
        status.put("message",message);
        this.data = data;
    }
}
