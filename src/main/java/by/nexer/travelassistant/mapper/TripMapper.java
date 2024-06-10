package by.nexer.travelassistant.mapper;

import by.nexer.travelassistant.dto.TripDTO;
import by.nexer.travelassistant.model.entity.TripEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TripMapper {
    TripDTO toTripDTO(TripEntity tripEntity);
    TripEntity fromTripDTO(TripDTO tripEntity);

    List<TripDTO> toTripDTOList(List<TripEntity> tripEntity);
}
