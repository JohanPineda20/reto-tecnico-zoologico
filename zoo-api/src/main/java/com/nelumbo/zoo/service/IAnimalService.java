package com.nelumbo.zoo.service;

import com.nelumbo.zoo.dto.request.CreateCommentRequest;
import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.model.CommentModel;
import com.nelumbo.zoo.model.CustomPage;

public interface IAnimalService {

    CustomPage<AnimalModel> findAll(Integer page, Integer size);

    AnimalModel findOneWithSpecieAndArea(Long id);

    AnimalModel create(AnimalModel animalModel);

    AnimalModel update(Long id, AnimalModel animalModel);

    AnimalModel delete(Long id);

    CommentModel createComment(Long id, CommentModel commentModel);

    void deleteComment(Long id, Long commentId);

    CommentModel createReply(Long id, Long commentId, CommentModel commentModel);
}
