package by.nexer.travelassistant.repository;

import by.nexer.travelassistant.model.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends JpaRepository<TripEntity, Long> {
    @Query("SELECT t FROM TripEntity t JOIN t.users u WHERE u.id = :userId")
    List<TripEntity> findAllTripsByParticipant(@Param("userId") Long userId);

}
