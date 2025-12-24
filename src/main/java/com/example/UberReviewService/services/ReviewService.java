package com.example.UberReviewService.services;

import com.example.UberProject_EntityService.models.Review;
import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.dtos.UpdateReviewDto;

import java.util.List;

public interface ReviewService {
    public ReviewDto publishReview(Review review);
    public List<ReviewDto> getReviews();
    public ReviewDto getReview(Long id);
    public Boolean deleteReview(Long id);
    public ReviewDto updateReview(Long id, UpdateReviewDto updateReviewDto);
}
