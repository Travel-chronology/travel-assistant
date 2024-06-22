package by.nexer.travelassistant.controller;

import by.nexer.travelassistant.controller.OpenAPI.UserApi;
import by.nexer.travelassistant.model.entity.TravelAssistantUserEntity;
import by.nexer.travelassistant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<TravelAssistantUserEntity>> getUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelAssistantUserEntity> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping()
    public ResponseEntity<TravelAssistantUserEntity> createUser(@RequestBody TravelAssistantUserEntity user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/{id}")
    public ResponseEntity<TravelAssistantUserEntity> updateUser(@PathVariable Long id, @RequestBody TravelAssistantUserEntity body) {
        return ResponseEntity.ok(userService.updateUser(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User with id " + id + " was deleted");
    }
}