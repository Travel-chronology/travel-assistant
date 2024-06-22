package by.nexer.travelassistant.controller.OpenAPI;

import by.nexer.travelassistant.dto.request.TripRequest;
import by.nexer.travelassistant.dto.response.TripResponse;
import by.nexer.travelassistant.model.entity.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Tag(name = "Trips", description = "Inner Api for admin")
public interface TripApi {
    @Operation(
            summary = "Fetch all trips")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<List<TripResponse>> getTrips(Principal principal);

    @Operation(
            summary = "Fetch trip by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<TripResponse> getTrip(@PathVariable Long id);

    @Operation(summary = "Create trip")
    public ResponseEntity<TripResponse> createTrip(Principal principal, @RequestBody TripRequest body);

    @Operation(summary = "Update trip by id")
    public ResponseEntity<TripResponse> updateTrip(@PathVariable Long id, @RequestBody TripRequest body);

    @Operation(summary = "Delete trip by id")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id);

    @Operation(summary = "Add member to trip by id")
    public ResponseEntity<String> addMember(@PathVariable Long id, @RequestParam String email);

    @Operation(summary = "Delete member from trip by id")
    public ResponseEntity<String> deleteTrip(@PathVariable Long tripId, @PathVariable Long userId);
}
