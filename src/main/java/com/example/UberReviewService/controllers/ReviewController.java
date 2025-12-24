package com.example.UberReviewService.controllers;
import com.example.UberProject_EntityService.models.Review;
import com.example.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.dtos.UpdateReviewDto;
import com.example.UberReviewService.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/reviews")
@RestController
public class ReviewController {
    private final ReviewService reviewService;
    private final CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter){
        this.reviewService=reviewService;
        this.createReviewDtoToReviewAdapter=createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> publishReview(@RequestBody CreateReviewDto request){
        Review incomingReview=this.createReviewDtoToReviewAdapter.convertDto(request);
        if(incomingReview==null){
            return new ResponseEntity<>("Invalid arguments",HttpStatus.BAD_REQUEST);
        }
        ReviewDto response=this.reviewService.publishReview(incomingReview);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getReviews(){
        List<ReviewDto> response=this.reviewService.getReviews();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReview(@PathVariable Long id){
        ReviewDto dto = reviewService.getReview(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id){
       Boolean deleted=reviewService.deleteReview(id);
       return deleted
               ?ResponseEntity.noContent().build()
               :ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long id, @RequestBody UpdateReviewDto updateReviewDto){
        ReviewDto updatedReview = reviewService.updateReview(id, updateReviewDto);
        return updatedReview != null
                ? ResponseEntity.ok(updatedReview)
                : ResponseEntity.notFound().build();
    }
}
