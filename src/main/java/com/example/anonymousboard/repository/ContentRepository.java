package com.example.anonymousboard.repository;

import com.example.anonymousboard.domain.Content;
import com.example.anonymousboard.dto.ContentGetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    List<ContentGetDto> findByCategoryId(int category);
}