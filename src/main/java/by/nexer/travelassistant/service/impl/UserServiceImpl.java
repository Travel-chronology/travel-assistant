package by.nexer.travelassistant.service.impl;

import by.nexer.travelassistant.mapper.UserMapper;
import by.nexer.travelassistant.model.entity.TravelAssistantUserEntity;
import by.nexer.travelassistant.repository.UserRepository;
import by.nexer.travelassistant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<TravelAssistantUserEntity> getAll() {
        return userRepository.findAll();
    }

    public TravelAssistantUserEntity getUserById(Long id) {
        Optional<TravelAssistantUserEntity> optional = userRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("User not found for id: " + id));
    }

    public TravelAssistantUserEntity createUser(TravelAssistantUserEntity user) {
        return userRepository.save(user);
    }

    public TravelAssistantUserEntity updateUser(Long id, TravelAssistantUserEntity body) {
        TravelAssistantUserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found for id: " + id));

        existingUser.setUserName(body.getUserName());
        existingUser.setFirstName(body.getFirstName());
        existingUser.setLastName(body.getLastName());
        existingUser.setEmail(body.getEmail());

        return userRepository.save(existingUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}