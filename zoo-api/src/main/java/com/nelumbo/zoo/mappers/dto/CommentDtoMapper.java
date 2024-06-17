package com.nelumbo.zoo.mappers.dto;

import com.nelumbo.zoo.dto.request.CreateCommentRequest;
import com.nelumbo.zoo.dto.response.CommentResponse;
import com.nelumbo.zoo.model.CommentModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CommentDtoMapper {
    CommentModel toCommentModel (CreateCommentRequest createCommentRequest);
    CommentResponse toCommentResponse(CommentModel commentModel);
}
