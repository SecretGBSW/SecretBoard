package com.example.anonymousboard.board.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ResponseListDataDto<Data> {
    private String status;
    private String message;
    private final List<Data> data;

    public ResponseListDataDto(String state, String message, List<Data> data) {
        this.status = state;
        this.message = message;
        this.data = data;
    }
}
