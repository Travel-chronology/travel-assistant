package by.nexer.travelassistant.service;
import by.nexer.travelassistant.model.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAll();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User body);

    void deleteUserById(Long id);
}
