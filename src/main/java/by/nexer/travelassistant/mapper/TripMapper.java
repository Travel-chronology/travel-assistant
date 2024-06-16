package by.nexer.travelassistant.mapper;

import by.nexer.travelassistant.dto.response.TripResponse;
import by.nexer.travelassistant.dto.request.TripRequest;
import by.nexer.travelassistant.model.entity.TripEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TripMapper {
    @Mapping(source = "users", target = "users")
    TripResponse fromEntity(TripEntity tripEntity);

    TripEntity toEntity(TripRequest tripRequest);

    @Mapping(source = "users", target = "users")
    List<TripResponse> fromEntityList(List<TripEntity> tripEntities);
}
