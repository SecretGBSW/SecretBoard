package com.example.anonymousboard.controller;

import com.example.anonymousboard.domain.Content;
import com.example.anonymousboard.dto.ContentAddDto;
import com.example.anonymousboard.dto.ContentGetDto;
import com.example.anonymousboard.service.ContentService;
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
            @PathVariable int contentId
    ) {
        return contentService.update(category, contentId);
    }

    @DeleteMapping("/{contentId}")
    public String delete(
            @PathVariable int category,
            @PathVariable int contentId
    ) {
        return contentService.delete(category, contentId);
    }
}
