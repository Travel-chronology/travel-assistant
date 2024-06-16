package by.nexer.travelassistant.mapper;

import by.nexer.travelassistant.dto.UserDTO;
import by.nexer.travelassistant.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDTO toUserDTO(UserEntity userEntity);
    UserEntity fromUserDTO(UserDTO userDTO);
}
