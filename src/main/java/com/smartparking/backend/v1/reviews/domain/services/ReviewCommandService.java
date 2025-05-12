package com.smartparking.backend.v1.reviews.domain.services;

import com.smartparking.backend.v1.reviews.domain.model.aggregates.Review;
import com.smartparking.backend.v1.reviews.domain.model.commands.CreateReviewCommand;

import java.util.Optional;

public interface ReviewCommandService {
    Optional<Review> handle(CreateReviewCommand command);
}
