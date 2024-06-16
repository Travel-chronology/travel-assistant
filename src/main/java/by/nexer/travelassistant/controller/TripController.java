package by.nexer.travelassistant.controller;

import by.nexer.travelassistant.dto.response.TripResponse;
import by.nexer.travelassistant.dto.request.TripRequest;
import by.nexer.travelassistant.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping
    public ResponseEntity<List<TripResponse>> getTrips(){
       return ResponseEntity.ok(tripService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripResponse> getTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PostMapping()
    public ResponseEntity<TripResponse> createTrip(@RequestBody TripRequest body) {
        return ResponseEntity.ok(tripService.createTrip(body));
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
}
