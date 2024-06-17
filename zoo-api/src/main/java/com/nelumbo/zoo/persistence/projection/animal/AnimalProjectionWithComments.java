package com.nelumbo.zoo.persistence.projection.animal;

import com.nelumbo.zoo.persistence.projection.comment.CommentProjectionWithReplies;

import java.util.List;

public interface AnimalProjectionWithComments extends AnimalProjection{
    List<CommentProjectionWithReplies> getComments();
}
