package com.nelumbo.zoo.persistence;

import com.nelumbo.zoo.model.CommentModel;

import java.util.Optional;

public interface ICommentPersistence {
    CommentModel save(CommentModel commentModel);

    Optional<CommentModel> findByIdAndAnimalId(Long commentId, Long animalId);

    void delete(CommentModel commentModel);
}
