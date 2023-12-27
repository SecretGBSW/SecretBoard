package com.example.anonymousboard.dto;

import com.example.anonymousboard.domain.Category;
import com.example.anonymousboard.domain.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddContentDto {
    private String title;
    private String content;
    private String user;
    @JsonIgnore
    private String pw;
}
