package com.smartparking.backend.v1.profile.domain.services;





import com.smartparking.backend.v1.profile.domain.model.aggregates.Driver;
import com.smartparking.backend.v1.profile.domain.model.queries.GetDriverByUserIdAsyncQuery;

import java.util.Optional;

public interface DriverQueryService {
    Optional<Driver> handle(GetDriverByUserIdAsyncQuery query);
}
