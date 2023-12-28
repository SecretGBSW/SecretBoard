package com.example.anonymousboard.board.repository;

import com.example.anonymousboard.board.domain.Content;
import com.example.anonymousboard.board.dto.ContentGetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    List<Content> findAllByCategoryId(int category);
}