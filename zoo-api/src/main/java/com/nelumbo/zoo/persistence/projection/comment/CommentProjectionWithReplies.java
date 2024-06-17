package com.nelumbo.zoo.persistence.projection.comment;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentProjectionWithReplies extends CommentProjection {
    List<CommentProjectionWithReplies> getReplies();
}
