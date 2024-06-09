package by.nexer.travelassistant.service;

import by.nexer.travelassistant.model.entity.UserEntity;
import java.util.List;

public interface UserService {
    List<UserEntity> getAll();

    UserEntity getUserById(Long id);

    UserEntity createUser(UserEntity user);

    UserEntity updateUser(Long id, UserEntity body);

    void deleteUserById(Long id);
}
