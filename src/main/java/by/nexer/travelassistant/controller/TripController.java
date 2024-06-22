package by.nexer.travelassistant.controller;

import by.nexer.travelassistant.controller.OpenAPI.TripApi;
import by.nexer.travelassistant.dto.response.TripResponse;
import by.nexer.travelassistant.dto.request.TripRequest;
import by.nexer.travelassistant.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/trips")
@RequiredArgsConstructor
public class TripController implements TripApi {
    private final TripService tripService;

    @GetMapping
    public ResponseEntity<List<TripResponse>> getTrips(Principal principal) {
        return ResponseEntity.ok(tripService.getAll(principal));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripResponse> getTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PostMapping()
    public ResponseEntity<TripResponse> createTrip(Principal principal, @RequestBody TripRequest body) {
        return ResponseEntity.ok(tripService.createTrip(principal, body));
    }

    @PostMapping("/{id}")
    public ResponseEntity<TripResponse> updateTrip(@PathVariable Long id, @RequestBody TripRequest body) {
        return ResponseEntity.ok(tripService.updateTrip(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id) {
        tripService.deleteTripById(id);
        return ResponseEntity.ok("Trip with id " + id + " was deleted");
    }

    @PostMapping("/{id}/members")
    public ResponseEntity<String> addMember(@PathVariable Long id, @RequestParam String email) {
        tripService.addMember(id, email);
        return ResponseEntity.ok("Member with email" + email + " was added");
    }

    @DeleteMapping("/{tripId}/members/{userId}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long tripId, @PathVariable Long userId) {
        tripService.deleteMemberById(tripId, userId);
        return ResponseEntity.ok("Member was deleted from trip");
    }
}
