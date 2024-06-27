package by.nexer.travelassistant.service.impl;

import by.nexer.travelassistant.dto.response.TripResponse;
import by.nexer.travelassistant.dto.request.TripRequest;
import by.nexer.travelassistant.mapper.TripMapper;
import by.nexer.travelassistant.model.entity.TravelAssistantUserEntity;
import by.nexer.travelassistant.model.entity.TripEntity;
import by.nexer.travelassistant.repository.TripRepository;
import by.nexer.travelassistant.repository.UserRepository;
import by.nexer.travelassistant.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final TripMapper tripMapper;

    public List<TripResponse> getAll(Principal principal) {
        String userEmail = principal.getName();
        List<TripEntity> trips = tripRepository.findAllTripsByParticipant(userEmail);
        return tripMapper.fromEntityList(trips);
    }

    public TripResponse getTripById(Long id) {
        Optional<TripEntity> optional = tripRepository.findById(id);
        return tripMapper.fromEntity(optional.orElseThrow(() -> new RuntimeException("Trip not found for id: " + id)));
    }


    public TripResponse createTrip(Principal principal, TripRequest body) {
        String userEmail = principal.getName();

        TripEntity tripEntity = tripMapper.toEntity(body);

        TravelAssistantUserEntity travelAssistantUserEntity = userRepository.findUserByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found for user email: " + userEmail));

        tripEntity.getUsers().add(travelAssistantUserEntity);

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

    public void addMember(Long tripId, String email){
        TravelAssistantUserEntity travelAssistantUserEntity = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found for email: " + email));

        TripEntity tripEntity = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found for id: " + tripId));

        tripEntity.getUsers().add(travelAssistantUserEntity);
        tripRepository.save(tripEntity);
    }

    public void deleteMemberById(Long tripId, Long userId) {
        TripEntity tripEntity = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found for id: " + tripId));

        TravelAssistantUserEntity travelAssistantUserEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found for id: " + userId));

        tripEntity.getUsers().remove(travelAssistantUserEntity);
        tripRepository.save(tripEntity);
    }
}
