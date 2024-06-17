package com.nelumbo.zoo.controller;

import java.net.URI;

import com.nelumbo.zoo.dto.request.CreateCommentRequest;
import com.nelumbo.zoo.dto.response.CommentResponse;
import com.nelumbo.zoo.mappers.dto.CommentDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nelumbo.zoo.dto.request.CreateAnimalRequest;
import com.nelumbo.zoo.dto.response.AnimalResponse;
import com.nelumbo.zoo.mappers.dto.AnimalDtoMapper;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.service.IAnimalService;
import com.nelumbo.zoo.utils.Constants;
import com.nelumbo.zoo.utils.CustomPageConverter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("v1/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final IAnimalService animalService;
    private final AnimalDtoMapper animalDtoMapper;
    private final CommentDtoMapper commentDtoMapper;

    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @GetMapping
    public ResponseEntity<CustomPage<AnimalResponse>> findAll(@RequestParam(defaultValue = "0") Integer page,
                                                              @RequestParam(defaultValue = "10") Integer size) {
        CustomPage<AnimalResponse> animalResponsePage = CustomPageConverter.convertCustomPage(animalService.findAll(page, size), animalDtoMapper::toAnimalResponse); 
        return ResponseEntity.ok(animalResponsePage);
    }

    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @GetMapping("{id}")
    public ResponseEntity<AnimalResponse> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(animalDtoMapper.toAnimalResponse(animalService.findOneWithSpecieAndArea(id)));
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @PostMapping
    public ResponseEntity<AnimalResponse> create(@RequestBody @Valid CreateAnimalRequest createAnimalRequest) {
        AnimalResponse animalResponse = animalDtoMapper.toAnimalResponse(animalService.create(animalDtoMapper.toAnimalModel(createAnimalRequest)));
        return ResponseEntity.created(URI.create(String.format("/api/v1/animals/%s", animalResponse.getId())))
        .body(animalResponse);
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @PutMapping("{id}")
    public ResponseEntity<AnimalResponse> update(@PathVariable Long id, @RequestBody @Valid CreateAnimalRequest createAnimalRequest) {
        AnimalResponse animalResponse = animalDtoMapper.toAnimalResponse(animalService.update(id, animalDtoMapper.toAnimalModel(createAnimalRequest)));
        return ResponseEntity.ok(animalResponse);
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @DeleteMapping("{id}")
    public ResponseEntity<AnimalResponse> delete(@PathVariable Long id) {
        AnimalResponse animalResponse = animalDtoMapper.toAnimalResponse(animalService.delete(id));
        return ResponseEntity.ok(animalResponse);
    }

    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @PostMapping("{id}/comments")
    public ResponseEntity<CommentResponse> createComment(@PathVariable Long id,
                                                         @RequestBody CreateCommentRequest createCommentRequest) {
        return ResponseEntity.ok(commentDtoMapper.toCommentResponse(animalService.createComment(id, commentDtoMapper.toCommentModel(createCommentRequest))));
    }
    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @DeleteMapping("{id}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id, @PathVariable Long commentId) {
        animalService.deleteComment(id, commentId);
        return ResponseEntity.noContent().build();
    }
    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @PostMapping("{id}/comments/{commentId}")
    public ResponseEntity<CommentResponse> createReply(@PathVariable Long id,
                                                       @PathVariable Long commentId,
                                                       @RequestBody CreateCommentRequest createCommentRequest) {
        return ResponseEntity.ok(commentDtoMapper.toCommentResponse(animalService.createReply(id, commentId, commentDtoMapper.toCommentModel(createCommentRequest))));
    }
}