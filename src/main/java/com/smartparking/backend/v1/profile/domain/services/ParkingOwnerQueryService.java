package com.smartparking.backend.v1.profile.domain.services;





import com.smartparking.backend.v1.profile.domain.model.aggregates.ParkingOwner;
import com.smartparking.backend.v1.profile.domain.model.queries.GetParkingOwnerByUserIdAsyncQuery;

import java.util.Optional;

public interface ParkingOwnerQueryService {
    Optional<ParkingOwner> handle(GetParkingOwnerByUserIdAsyncQuery query);
}
