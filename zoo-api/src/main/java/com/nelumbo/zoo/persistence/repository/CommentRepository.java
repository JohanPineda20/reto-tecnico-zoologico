package com.nelumbo.zoo.persistence.repository;

import com.nelumbo.zoo.persistence.entity.CommentEntity;

import com.nelumbo.zoo.persistence.projection.comment.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<CommentProjection> findByIdAndAnimalId(Long commentId, Long animalId);
}
