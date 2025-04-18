package com.smartparking.backend.v1.iam.interfaces.rest.transform;

import com.smartparking.backend.v1.iam.domain.model.commands.SignInCommand;
import com.smartparking.backend.v1.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
