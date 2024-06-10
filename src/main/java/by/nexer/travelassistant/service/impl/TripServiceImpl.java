package by.nexer.travelassistant.service.impl;

import by.nexer.travelassistant.dto.TripDTO;
import by.nexer.travelassistant.mapper.TripMapper;
import by.nexer.travelassistant.model.entity.TripEntity;
import by.nexer.travelassistant.repository.TripRepository;
import by.nexer.travelassistant.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    public List<TripDTO> getAll() {
        List<TripEntity> trips = tripRepository.findAll();
        return tripMapper.toTripDTOList(trips);
    }

    public TripDTO getTripById(Long id) {
        Optional<TripEntity> optional = tripRepository.findById(id);
        return tripMapper.toTripDTO(optional.orElseThrow(() -> new RuntimeException("Trip not found for id: " + id)));
    }


    public TripDTO createTrip(TripDTO trip) {
        TripEntity tripEntity = tripMapper.fromTripDTO(trip);
        tripRepository.save(tripEntity);
        return trip;
    }

    @Override
    public TripDTO updateTrip(Long id, TripDTO body) {
        TripEntity existingTrip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found for id: " + id));

        existingTrip.setTitle(body.getTitle());
        existingTrip.setDescription(body.getDescription());
        existingTrip.setStartDate(body.getStartDate());
        existingTrip.setEndDate(body.getEndDate());
//        existingTrip.setUsers(); //todo users

        tripRepository.save(existingTrip);
        return body;
    }

    public void deleteTripById(Long id) {
        tripRepository.deleteById(id);
    }
}
