package com.example.anonymousboard.board.controller;

import com.example.anonymousboard.board.domain.Comment;
import com.example.anonymousboard.board.dto.*;
import com.example.anonymousboard.board.dto.response.ResponseListDataDto;
import com.example.anonymousboard.board.dto.response.ResponseMessageDto;
import com.example.anonymousboard.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories/{category}/contents/{contentId}/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseListDataDto<Comment> getComments(
            @PathVariable int category,
            @PathVariable int contentId
    ) {
        return new ResponseListDataDto<>(
          HttpStatus.OK.toString(),
          "message",
          commentService.getComments(category, contentId)
        );
    }
    @PostMapping
    public ResponseMessageDto addComment(
            @PathVariable int category,
            @PathVariable int contentId,
            @RequestBody CommentAddDto dto
    ) {
        return new ResponseMessageDto(
                HttpStatus.OK.toString(),
                commentService.addComment(category, contentId, dto)
        );
    }

    @PutMapping("/{commentId}")
    public ResponseMessageDto update(
            @PathVariable int category,
            @PathVariable int contentId,
            @PathVariable int commentId,
            @RequestBody CommentUpdateDto dto
    ) {
        return new ResponseMessageDto(
                HttpStatus.OK.toString(),
                commentService.update(category, contentId, commentId, dto)
        );
    }

    @DeleteMapping("/{commentId}")
    public ResponseMessageDto delete(
            @PathVariable int category,
            @PathVariable int contentId,
            @PathVariable int commentId,
            @RequestBody CommentDeleteDto dto
            ) {

        return new ResponseMessageDto(
                HttpStatus.OK.toString(),
                commentService.delete(category, contentId, commentId, dto)
        );
    }
}
