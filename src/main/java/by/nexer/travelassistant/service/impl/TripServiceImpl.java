package by.nexer.travelassistant.service.impl;

import by.nexer.travelassistant.dto.TripDTO;
import by.nexer.travelassistant.mapper.TripMapper;
import by.nexer.travelassistant.model.entity.TripEntity;
import by.nexer.travelassistant.model.entity.UserEntity;
import by.nexer.travelassistant.repository.TripRepository;
import by.nexer.travelassistant.repository.UserRepository;
import by.nexer.travelassistant.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final TripMapper tripMapper;

    public List<TripDTO> getAll() {
        Long userId = 1L;// todo request with id
        List<TripEntity> trips = tripRepository.findAllTripsByParticipant(userId);
        return tripMapper.toTripDTOList(trips);
    }

    public TripDTO getTripById(Long id) {
        Optional<TripEntity> optional = tripRepository.findById(id);
        return tripMapper.toTripDTO(optional.orElseThrow(() -> new RuntimeException("Trip not found for id: " + id)));
    }


    public TripDTO createTrip(TripDTO trip) {
        Long userId = 1L; // TODO: request with id

        TripEntity tripEntity = tripMapper.fromTripDTO(trip);

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found for id: " + userId));

        tripEntity.getUsers().add(userEntity);

        tripRepository.save(tripEntity);

        return tripMapper.toTripDTO(tripEntity);
    }

    @Override
    public TripDTO updateTrip(Long id, TripDTO body) {
        TripEntity existingTrip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found for id: " + id));

        Set<UserEntity> users = body.getUsers().stream()
                .map(userDTO -> userRepository.findById(userDTO.getId())
                        .orElseThrow(() -> new RuntimeException("User not found for id: " + userDTO.getId())))
                .collect(Collectors.toSet());

        existingTrip.setTitle(body.getTitle());
        existingTrip.setDescription(body.getDescription());
        existingTrip.setStartDate(body.getStartDate());
        existingTrip.setEndDate(body.getEndDate());
        existingTrip.setUsers(users);

        tripRepository.save(existingTrip);
        return tripMapper.toTripDTO(existingTrip);
    }

    public void deleteTripById(Long id) {
        tripRepository.deleteById(id);
    }
}
