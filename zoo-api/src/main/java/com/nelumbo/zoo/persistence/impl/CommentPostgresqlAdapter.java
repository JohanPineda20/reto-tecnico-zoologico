package com.nelumbo.zoo.persistence.impl;

import com.nelumbo.zoo.mappers.entity.CommentEntityMapper;
import com.nelumbo.zoo.persistence.ICommentPersistence;
import com.nelumbo.zoo.persistence.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentPostgresqlAdapter implements ICommentPersistence {
    private final CommentRepository commentRepository;
    private final CommentEntityMapper commentEntityMapper;

  
}
