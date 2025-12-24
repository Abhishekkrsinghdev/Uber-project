package com.example.UberReviewService.mapper;

import com.example.UberProject_EntityService.models.Review;
import com.example.UberReviewService.dtos.ReviewDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewMapper {
    public ReviewDto toDto(Review review) {
        if (review == null) return null;
        return ReviewDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .booking(review.getBooking().getId())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public List<ReviewDto> toDtoList(List<Review> reviews) {
        return reviews.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
