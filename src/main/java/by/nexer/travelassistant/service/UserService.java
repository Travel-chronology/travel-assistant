package by.nexer.travelassistant.service;

import by.nexer.travelassistant.model.entity.User;
import by.nexer.travelassistant.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("User not found for id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User body){
        User existingUser = userRepository.findById(id)
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
