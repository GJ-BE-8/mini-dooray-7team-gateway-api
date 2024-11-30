package com.nhnacademy.minidooray.gateway.domain.comment.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Comment {
    private Long id;
    private String content;
    private Long taskId;
}
