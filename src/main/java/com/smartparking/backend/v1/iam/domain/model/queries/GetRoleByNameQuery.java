package com.smartparking.backend.v1.iam.domain.model.queries;

import com.smartparking.backend.v1.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
