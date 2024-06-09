package by.nexer.travelassistant.mapper;

import by.nexer.travelassistant.dto.TripDTO;
import by.nexer.travelassistant.model.entity.TripEntity;

//@Mapper(componentModel = "spring")
public interface TripMapper {
//    TripMapper INSTANCE = Mappers.getMapper(TripMapper.class);
    TripDTO toDTO (TripEntity tripEntity);
}
