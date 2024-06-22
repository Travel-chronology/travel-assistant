package by.nexer.travelassistant.service;

import by.nexer.travelassistant.dto.response.TripResponse;
import by.nexer.travelassistant.dto.request.TripRequest;

import java.security.Principal;
import java.util.List;

public interface TripService {
    List<TripResponse> getAll(Principal principal);

    TripResponse getTripById(Long id);

    TripResponse createTrip(Principal principal, TripRequest body);

    TripResponse updateTrip(Long id, TripRequest body);

    void deleteTripById(Long id);

    void addMember(Long tripId, String email);

    void deleteMemberById(Long tripId, Long userId);
}
