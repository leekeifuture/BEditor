package com.company.BEditor.repo;

import com.company.BEditor.domain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
