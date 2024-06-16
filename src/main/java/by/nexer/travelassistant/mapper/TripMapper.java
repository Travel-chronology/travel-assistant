package by.nexer.travelassistant.mapper;

import by.nexer.travelassistant.dto.TripDTO;
import by.nexer.travelassistant.model.entity.TripEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TripMapper {
    @Mapping(source = "users", target = "users")
    TripDTO toTripDTO(TripEntity tripEntity);
    @Mapping(source = "users", target = "users")
    TripEntity fromTripDTO(TripDTO tripDTO);

    @Mapping(source = "users", target = "users")
    List<TripDTO> toTripDTOList(List<TripEntity> tripEntities);

}
