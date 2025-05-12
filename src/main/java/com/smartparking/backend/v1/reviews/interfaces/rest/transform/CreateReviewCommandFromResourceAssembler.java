package com.smartparking.backend.v1.reviews.interfaces.rest.transform;

import com.smartparking.backend.v1.reviews.domain.model.commands.CreateReviewCommand;
import com.smartparking.backend.v1.reviews.interfaces.rest.resources.CreateReviewResource;

public class CreateReviewCommandFromResourceAssembler {
    public static CreateReviewCommand toCommandFromResource(CreateReviewResource resource) {
        return new CreateReviewCommand(
                resource.driverId(),
                resource.parkingId(),
                resource.comment(),
                resource.rating()
        );
    }
}
