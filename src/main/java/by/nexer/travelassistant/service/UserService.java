package by.nexer.travelassistant.service;

import by.nexer.travelassistant.model.entity.TravelAssistantUserEntity;

import java.util.List;

public interface UserService {
    List<TravelAssistantUserEntity> getAll();

    TravelAssistantUserEntity getUserById(Long id);

    TravelAssistantUserEntity createUser(TravelAssistantUserEntity user);

    TravelAssistantUserEntity updateUser(Long id, TravelAssistantUserEntity body);

    void deleteUserById(Long id);
}
