package by.nexer.travelassistant.mapper;

import by.nexer.travelassistant.dto.response.UserResponse;
import by.nexer.travelassistant.model.entity.TravelAssistantUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponse fromEntity(TravelAssistantUserEntity travelAssistantUserEntity);
    TravelAssistantUserEntity toEntity(UserResponse userResponse);
}
