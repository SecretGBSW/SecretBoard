package com.example.anonymousboard.board.controller;

import com.example.anonymousboard.board.domain.Content;
import com.example.anonymousboard.board.dto.*;
import com.example.anonymousboard.board.dto.response.ResponseDataDto;
import com.example.anonymousboard.board.dto.response.ResponseListDataDto;
import com.example.anonymousboard.board.dto.response.ResponseMessageDto;
import com.example.anonymousboard.board.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories/{category}/contents")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping
    public ResponseListDataDto<Content> contents(@PathVariable int category) {
        return new ResponseListDataDto<>(
                HttpStatus.OK.toString(),
                "조회 성공",
                contentService.getContents(category)
        );
    }

    @PostMapping("add")
    public ResponseMessageDto add(
            @PathVariable int category,
            @RequestBody ContentAddDto dto
    ) {
        contentService.add(category, dto);
        return new ResponseMessageDto(HttpStatus.OK.toString(), "게시글 추가가 완료되었습니다.");
    }
//상세 조회
    @GetMapping("/{contentId}")
    public ResponseDataDto<Content> getContent(
            @PathVariable int category,
            @PathVariable int contentId
    ) {
        return new ResponseDataDto<>(
                HttpStatus.OK.toString(),
                "message",
                contentService.getContent(category, contentId)
        );
    }

    @PutMapping("/{contentId}")
    public ResponseMessageDto update(
            @PathVariable int category,
            @PathVariable int contentId,
            @RequestBody ContentUpdateDto dto
            ) {
        return new ResponseMessageDto(
          HttpStatus.OK.toString(),
          contentService.update(category, contentId, dto)
        );
    }

    @DeleteMapping("/{contentId}")
    public ResponseMessageDto delete(
            @PathVariable int category,
            @PathVariable int contentId,
            @RequestBody ContentDeleteDto dto
    ) {
        return new ResponseMessageDto(
          HttpStatus.OK.toString(),
          contentService.delete(category, contentId, dto)
        );
    }
}
