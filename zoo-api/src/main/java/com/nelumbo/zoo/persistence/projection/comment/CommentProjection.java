package com.nelumbo.zoo.persistence.projection.comment;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentProjection {
    Long getId();
    String getBody();
    LocalDateTime getCreatedAt();
    UserProjection getAuthor();
    interface UserProjection{
        String getEmail();
    }
}
