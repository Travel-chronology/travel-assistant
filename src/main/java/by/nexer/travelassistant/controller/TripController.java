package by.nexer.travelassistant.controller;

import by.nexer.travelassistant.dto.TripDTO;
import by.nexer.travelassistant.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;
    @GetMapping
    public ResponseEntity<List<TripDTO>> getTrips(){
       return ResponseEntity.ok(tripService.getAll());
    }
}
