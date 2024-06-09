package by.nexer.travelassistant.service.impl;

import by.nexer.travelassistant.model.entity.UserEntity;
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

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        Optional<UserEntity> optional = userRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("User not found for id: " + id));
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(Long id, UserEntity body){
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found for id: " + id));

        existingUser.setUserName(body.getUserName());
        existingUser.setFirstName(body.getFirstName());
        existingUser.setLastName(body.getLastName());
        existingUser.setEmail(body.getEmail());
        existingUser.setPassword(body.getPassword());

        return userRepository.save(existingUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}