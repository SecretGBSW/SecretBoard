package com.example.anonymousboard.category.controller;

import com.example.anonymousboard.board.dto.response.ResponseListDataDto;
import com.example.anonymousboard.category.domain.Category;
import com.example.anonymousboard.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseListDataDto<Category> category() {
        return new ResponseListDataDto<>(HttpStatus.OK.toString(),"카테고리 조회 성공",categoryService.getCategory());
    }
}
