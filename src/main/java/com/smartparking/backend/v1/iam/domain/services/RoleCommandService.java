package com.smartparking.backend.v1.iam.domain.services;

import com.smartparking.backend.v1.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
