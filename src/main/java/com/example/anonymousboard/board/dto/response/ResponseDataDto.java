package com.example.anonymousboard.board.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ResponseDataDto<Data> {
    private String status;
    private String message;
    private Data data;

    public ResponseDataDto(String state, String message, Data data) {
        this.status = state;
        this.message = message;
        this.data = data;
    }
}
