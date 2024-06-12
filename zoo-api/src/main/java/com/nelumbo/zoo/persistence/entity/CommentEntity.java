package com.nelumbo.zoo.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    String body;

    @ManyToOne
    @JoinColumn(name = "author_id")
    UserEntity author;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    AnimalEntity animal;

    @ManyToOne()
    @JoinColumn(name = "parent_id")
    CommentEntity parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.REMOVE)
    List<CommentEntity> replies;
}
