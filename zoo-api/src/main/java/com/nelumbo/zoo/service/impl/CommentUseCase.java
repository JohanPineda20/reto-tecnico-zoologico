package com.nelumbo.zoo.service.impl;

import com.nelumbo.zoo.dto.request.CreateCommentRequest;
import com.nelumbo.zoo.mappers.entity.CommentEntityMapper;
import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.model.CommentModel;
import com.nelumbo.zoo.model.UserModel;
import com.nelumbo.zoo.persistence.ICommentPersistence;
import com.nelumbo.zoo.security.auth.authinformation.IAuthInformation;
import com.nelumbo.zoo.service.ICommentService;
import com.nelumbo.zoo.service.IUserService;
import com.nelumbo.zoo.utils.Constants;
import com.nelumbo.zoo.utils.exceptions.DataNotFoundException;
import com.nelumbo.zoo.utils.exceptions.DomainException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Transactional
@RequiredArgsConstructor
public class CommentUseCase implements ICommentService {

    private final ICommentPersistence commentPersistence;
    private final IAuthInformation authInformation;
    private final IUserService userService;

    @Override
    public CommentModel createComment(AnimalModel animalModel, CommentModel commentModel) {
        Long userId = authInformation.getIdFromAuthentication();
        UserModel userModel = userService.findById(userId);
        commentModel.setAnimal(animalModel);
        commentModel.setAuthor(userModel);
        return commentPersistence.save(commentModel);
    }

    @Override
    public void deleteComment(Long animalId, Long commentId){
        Long userId = authInformation.getIdFromAuthentication();
        UserModel userModel = userService.findById(userId);
        CommentModel commentModel = commentPersistence.findByIdAndAnimalId(commentId, animalId).orElseThrow(() -> new DataNotFoundException(Constants.COMMENT_NOT_FOUND));
        if(!Objects.equals(userModel.getEmail(), commentModel.getAuthor().getEmail())) throw new DomainException(Constants.CANNOT_DELETE_COMMENT);
        commentPersistence.delete(commentModel);
    }

    @Override
    public CommentModel createReply(Long animalId, Long commentId, CommentModel commentModel) {
        Long userId = authInformation.getIdFromAuthentication();
        UserModel userModel = userService.findById(userId);
        CommentModel commentModel1 = commentPersistence.findByIdAndAnimalId(commentId, animalId).orElseThrow(() -> new DataNotFoundException(Constants.COMMENT_NOT_FOUND));
        commentModel.setAuthor(userModel);
        commentModel.setParentComment(commentModel1);
        return commentPersistence.save(commentModel);
    }
}