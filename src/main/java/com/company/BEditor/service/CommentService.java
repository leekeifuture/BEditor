package com.company.BEditor.service;

import com.company.BEditor.domain.Comment;
import com.company.BEditor.domain.User;
import com.company.BEditor.domain.Views;
import com.company.BEditor.dto.EventType;
import com.company.BEditor.dto.ObjectType;
import com.company.BEditor.repo.CommentRepo;
import com.company.BEditor.util.WsSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {

    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    @Lazy
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}
