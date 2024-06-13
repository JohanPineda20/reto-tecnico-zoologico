package com.nelumbo.zoo.service.impl;

import com.nelumbo.zoo.persistence.ICommentPersistence;
import com.nelumbo.zoo.service.ICommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
public class CommentUseCase implements ICommentService {

    private final ICommentPersistence commentPersistence;
    
}