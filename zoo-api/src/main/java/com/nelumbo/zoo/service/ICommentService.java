package com.nelumbo.zoo.service;

import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.model.CommentModel;

public interface ICommentService {

    CommentModel createComment(AnimalModel animalModel, CommentModel commentModel);

    void deleteComment(Long animalId, Long commentId);

    CommentModel createReply(Long animalId, Long commentId, CommentModel commentModel);
}
