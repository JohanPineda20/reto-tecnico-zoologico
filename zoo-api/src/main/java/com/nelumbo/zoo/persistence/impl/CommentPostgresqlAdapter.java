package com.nelumbo.zoo.persistence.impl;

import com.nelumbo.zoo.mappers.entity.CommentEntityMapper;
import com.nelumbo.zoo.model.CommentModel;
import com.nelumbo.zoo.persistence.ICommentPersistence;
import com.nelumbo.zoo.persistence.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CommentPostgresqlAdapter implements ICommentPersistence {
    private final CommentRepository commentRepository;
    private final CommentEntityMapper commentEntityMapper;
    @Override
    public CommentModel save(CommentModel commentModel) {
        return commentEntityMapper.toCommentModel(commentRepository.save(commentEntityMapper.toCommentEntity(commentModel)));
    }

    @Override
    public Optional<CommentModel> findByIdAndAnimalId(Long commentId, Long animalId) {
        return commentRepository.findByIdAndAnimalId(commentId, animalId).map(commentEntityMapper::commentProjectionToCommentModel);
    }
    @Override
    public void delete(CommentModel commentModel) {
        commentRepository.deleteById(commentModel.getId());
    }
}
