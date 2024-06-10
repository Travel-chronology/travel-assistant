package by.nexer.travelassistant.service;

import by.nexer.travelassistant.dto.TripDTO;
import java.util.List;

public interface TripService {
    List<TripDTO> getAll();

    TripDTO getTripById(Long id);

    TripDTO createTrip(TripDTO user);

    TripDTO updateTrip(Long id, TripDTO body);

    void deleteTripById(Long id);
}
