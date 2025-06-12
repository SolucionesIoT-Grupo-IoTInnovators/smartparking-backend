package com.smartparking.backend.v1.deviceManagement.interfaces.rest;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.Device;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetDeviceByParkingSpotIdQuery;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetDevicesByEdgeServerIdQuery;
import com.smartparking.backend.v1.deviceManagement.domain.services.DeviceCommandService;
import com.smartparking.backend.v1.deviceManagement.domain.services.DeviceQueryService;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources.CreateDeviceResource;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources.DeviceResource;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.transform.CreateDeviceCommandFromResourceAssembler;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.transform.DeviceResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/devices", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Device", description = "Device management")
public class DevicesController {
    private final DeviceCommandService deviceCommandService;
    private final DeviceQueryService deviceQueryService;

    public DevicesController(DeviceCommandService deviceCommandService, DeviceQueryService deviceQueryService) {
        this.deviceCommandService = deviceCommandService;
        this.deviceQueryService = deviceQueryService;
    }

    @Operation(summary = "Create a new device")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Device created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    public ResponseEntity<DeviceResource> createDevice(@RequestBody CreateDeviceResource resource) {
        Optional<Device> device = this.deviceCommandService
                .handle(CreateDeviceCommandFromResourceAssembler.toCommandFromResource(resource));

        return device.map(source->
                        new ResponseEntity<>(DeviceResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get device by parking spot id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Device retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Device not found")
    })
    @GetMapping("/parking-spot/{parkingSpotId}")
    public ResponseEntity<DeviceResource> getDeviceByParkingSpotId(@PathVariable String parkingSpotId) {
        var query = new GetDeviceByParkingSpotIdQuery(UUID.fromString(parkingSpotId));
        Optional<Device> device = this.deviceQueryService.handle(query);
        return device.map(source ->
                        ResponseEntity.ok(DeviceResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get devices by edge server id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Devices retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No devices found")
    })
    @GetMapping("/edge-server/{edgeServerId}")
    public ResponseEntity<List<DeviceResource>> getDevicesByEdgeServerId(@PathVariable Long edgeServerId) {
        var query = new GetDevicesByEdgeServerIdQuery(edgeServerId);
        List<Device> devices = this.deviceQueryService.handle(query);
        
        if (devices.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        List<DeviceResource> resources = devices.stream()
                .map(DeviceResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
}
