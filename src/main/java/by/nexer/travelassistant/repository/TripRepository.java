package by.nexer.travelassistant.repository;

import by.nexer.travelassistant.model.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripEntity, Long> {
}
