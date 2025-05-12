package com.smartparking.backend.v1.reviews.domain.services;

import com.smartparking.backend.v1.reviews.domain.model.aggregates.Review;
import com.smartparking.backend.v1.reviews.domain.model.queries.GetReviewsByDriverIdQuery;
import com.smartparking.backend.v1.reviews.domain.model.queries.GetReviewsByParkingIdQuery;

import java.util.List;

public interface ReviewQueryService {
    List<Review> handle(GetReviewsByDriverIdQuery query);
    List<Review> handle(GetReviewsByParkingIdQuery query);
}
