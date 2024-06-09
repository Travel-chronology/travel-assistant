package by.nexer.travelassistant.model.repository;

import by.nexer.travelassistant.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
