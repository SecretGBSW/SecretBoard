package com.example.anonymousboard.board.controller;

import com.example.anonymousboard.board.domain.Comment;
import com.example.anonymousboard.board.dto.*;
import com.example.anonymousboard.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{category}/contents/{contentId}")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseListDataDto<Comment> getComments(
            @PathVariable int category,
            @PathVariable int contentId
    ) {
        return new ResponseListDataDto<>(HttpStatus.OK.toString(), "message", commentService.getComments(category, contentId));
    }
    @PostMapping
    public ResponseMessageDto addComment(
            @PathVariable int category,
            @PathVariable int contentId,
            @RequestBody CommentAddDto dto
    ) {
        commentService.addComment(category, contentId, dto);
        return new ResponseMessageDto(HttpStatus.OK.toString(), "댓글이 추가가 완료되었습니다.");
    }

    @PutMapping("/{commentId}")
    public ResponseMessageDto update(
            @PathVariable int category,
            @PathVariable int contentId,
            @PathVariable int commentId,
            @RequestBody CommentUpdateDto dto
    ) {
        commentService.update(category, contentId, commentId, dto);
        return new ResponseMessageDto(HttpStatus.OK.toString(), "댓글이 수정이 완료되었습니다.");
    }

    @DeleteMapping("/{commentId}")
    public ResponseMessageDto delete(
            @PathVariable int category,
            @PathVariable int contentId,
            @PathVariable int commentId,
            @RequestBody CommentDeleteDto dto
            ) {

        commentService.delete(category, contentId, commentId, dto);
        return new ResponseMessageDto(HttpStatus.OK.toString(), "댓글이 수정이 완료되었습니다.");
    }
}
