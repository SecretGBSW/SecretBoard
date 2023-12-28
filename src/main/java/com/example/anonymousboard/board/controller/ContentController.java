package com.example.anonymousboard.board.controller;

import com.example.anonymousboard.board.domain.Content;
import com.example.anonymousboard.board.dto.ContentAddDto;
import com.example.anonymousboard.board.dto.ContentDeleteDto;
import com.example.anonymousboard.board.dto.ContentGetDto;
import com.example.anonymousboard.board.dto.ContentUpdateDto;
import com.example.anonymousboard.board.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{category}/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<ContentGetDto> contents(@PathVariable int category) {
        return contentService.getContents(category);
    }

    @PostMapping("add")
    public Content add(
            @PathVariable int category,
            @RequestBody ContentAddDto dto
    ) {
        return contentService.add(category, dto);
    }

    @GetMapping("/{contentId}")
    public Content getContent(
            @PathVariable int category,
            @PathVariable int contentId
    ) {
        return contentService.getContent(category, contentId);
    }

    @PutMapping("/{contentId}")
    public Content update(
            @PathVariable int category,
            @PathVariable int contentId,
            @RequestBody ContentUpdateDto dto
            ) {
        return contentService.update(category, contentId, dto);
    }

    @DeleteMapping("/{contentId}")
    public String delete(
            @PathVariable int category,
            @PathVariable int contentId,
            @RequestBody ContentDeleteDto dto
    ) {
        return contentService.delete(category, contentId);
    }
}
