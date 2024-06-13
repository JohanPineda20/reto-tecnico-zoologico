package com.nelumbo.zoo.mappers.entity;

import com.nelumbo.zoo.model.CommentModel;
import com.nelumbo.zoo.persistence.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CommentEntityMapper {
    CommentModel toCommentModel(CommentEntity commentEntity);
    CommentEntity toCommentEntity(CommentModel commentModel);
}
