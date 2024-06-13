package com.nelumbo.zoo.utils;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import com.nelumbo.zoo.model.CustomPage;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomPageConverter {
    
    public static <T, R> CustomPage<R> convertCustomPage(CustomPage<T> sourcePage, Function<T, R> converter) {
        List<R> content = sourcePage.getContent().stream()
            .map(converter)
            .toList();

        return new CustomPage<>(
            content,
            sourcePage.getNumber(),
            sourcePage.getSize(),
            sourcePage.getTotalElements(),
            sourcePage.getTotalPages(),
            sourcePage.isLast(),
            sourcePage.isFirst()
        );
    }

    public static <T, R> CustomPage<R> convertPage(Page<T> sourcePage, Function<T, R> converter) {
        List<R> content = sourcePage.getContent().stream()
            .map(converter)
            .toList();

        return new CustomPage<>(
            content,
            sourcePage.getNumber(),
            sourcePage.getSize(),
            sourcePage.getTotalElements(),
            sourcePage.getTotalPages(),
            sourcePage.isLast(),
            sourcePage.isFirst()
        );
    }
}