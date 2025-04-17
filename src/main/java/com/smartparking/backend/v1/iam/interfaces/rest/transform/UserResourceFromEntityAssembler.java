package com.smartparking.backend.v1.iam.interfaces.rest.transform;

import com.smartparking.backend.v1.iam.domain.model.aggregates.User;
import com.smartparking.backend.v1.iam.domain.model.entities.Role;
import com.smartparking.backend.v1.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getEmail(), roles);
    }
}