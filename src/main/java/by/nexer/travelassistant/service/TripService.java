package by.nexer.travelassistant.service;

import by.nexer.travelassistant.dto.response.TripResponse;
import by.nexer.travelassistant.dto.request.TripRequest;

import java.util.List;

public interface TripService {
    List<TripResponse> getAll();

    TripResponse getTripById(Long id);

    TripResponse createTrip(TripRequest body);

    TripResponse updateTrip(Long id, TripRequest body);

    void deleteTripById(Long id);
}
