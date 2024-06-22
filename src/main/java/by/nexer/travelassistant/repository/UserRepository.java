package by.nexer.travelassistant.repository;

import by.nexer.travelassistant.model.entity.TravelAssistantUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TravelAssistantUserEntity, Long> {
    Optional<TravelAssistantUserEntity> findUserByEmail(String email);
}
