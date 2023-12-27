package com.example.anonymousboard.controller;

import com.example.anonymousboard.domain.Content;
import com.example.anonymousboard.dto.AddContentDto;
import com.example.anonymousboard.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{category}/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Content> contents(@PathVariable int category) {
        return contentService.getContent(category);
    }

    @PostMapping("add")
    public Content add(
            @PathVariable int category,
            @RequestBody AddContentDto dto
    ) {
        return contentService.add(category, dto);
    }
}
