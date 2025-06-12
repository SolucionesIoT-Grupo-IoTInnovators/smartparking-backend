package com.smartparking.backend.v1.deviceManagement.interfaces.rest.transform;

import com.smartparking.backend.v1.deviceManagement.domain.model.commands.CreateEdgeServerCommand;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources.CreateEdgeServerResource;

public class CreateEdgeServerCommandFromResourceAssembler {

    public static CreateEdgeServerCommand toCommandFromResource(CreateEdgeServerResource resource) {
        return new CreateEdgeServerCommand(
                resource.name(),
                resource.ipAddress(),
                resource.parkingId()
        );
    }
}
