package by.nexer.travelassistant.mapper;

import by.nexer.travelassistant.dto.response.UserResponse;
import by.nexer.travelassistant.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponse fromEntity(UserEntity userEntity);
    UserEntity toEntity(UserResponse userResponse);
}
