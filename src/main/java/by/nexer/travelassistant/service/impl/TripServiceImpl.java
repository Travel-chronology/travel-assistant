package by.nexer.travelassistant.service.impl;

import by.nexer.travelassistant.dto.response.TripResponse;
import by.nexer.travelassistant.dto.request.TripRequest;
import by.nexer.travelassistant.mapper.TripMapper;
import by.nexer.travelassistant.model.entity.TripEntity;
import by.nexer.travelassistant.model.entity.UserEntity;
import by.nexer.travelassistant.repository.TripRepository;
import by.nexer.travelassistant.repository.UserRepository;
import by.nexer.travelassistant.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final TripMapper tripMapper;

    public List<TripResponse> getAll() {
        Long userId = 1L;// todo request with id
        List<TripEntity> trips = tripRepository.findAllTripsByParticipant(userId);
        return tripMapper.fromEntityList(trips);
    }

    public TripResponse getTripById(Long id) {
        Optional<TripEntity> optional = tripRepository.findById(id);
        return tripMapper.fromEntity(optional.orElseThrow(() -> new RuntimeException("Trip not found for id: " + id)));
    }


    public TripResponse createTrip(TripRequest body) {
        Long userId = 1L; // TODO: request with id

        TripEntity tripEntity = tripMapper.toEntity(body);

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found for id: " + userId));

        tripEntity.getUsers().add(userEntity);

        tripRepository.save(tripEntity);

        return tripMapper.fromEntity(tripEntity);
    }

    @Override
    public TripResponse updateTrip(Long id, TripRequest body) {
        TripEntity existingTrip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found for id: " + id));

        existingTrip.setTitle(body.getTitle());
        existingTrip.setDescription(body.getDescription());
        existingTrip.setStartDate(body.getStartDate());
        existingTrip.setEndDate(body.getEndDate());

        tripRepository.save(existingTrip);
        return tripMapper.fromEntity(existingTrip);
    }

    public void deleteTripById(Long id) {
        tripRepository.deleteById(id);
    }
}
