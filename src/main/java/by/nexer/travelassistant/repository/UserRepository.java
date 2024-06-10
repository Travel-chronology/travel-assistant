package by.nexer.travelassistant.repository;

import by.nexer.travelassistant.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
