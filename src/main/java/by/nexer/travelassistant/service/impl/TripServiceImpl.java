package by.nexer.travelassistant.service.impl;

import by.nexer.travelassistant.dto.TripDTO;
import by.nexer.travelassistant.repository.TripRepository;
import by.nexer.travelassistant.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    public List<TripDTO> getAll() {
        return null;
    }

    public TripDTO getTripById(Long id) {
        return null;
    }


    public TripDTO createTrip(TripDTO trip) {
        return null;
    }

    @Override
    public TripDTO updateTrip(Long id, TripDTO body) {
        return null;
    }

    public void deleteTripById(Long id) {
        tripRepository.deleteById(id);
    }
}
