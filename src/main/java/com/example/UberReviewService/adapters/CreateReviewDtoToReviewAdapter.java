package com.example.UberReviewService.adapters;

import com.example.UberProject_EntityService.models.Review;
import com.example.UberReviewService.dtos.CreateReviewDto;

public interface CreateReviewDtoToReviewAdapter {
    public Review convertDto(CreateReviewDto createReviewDto);
}
