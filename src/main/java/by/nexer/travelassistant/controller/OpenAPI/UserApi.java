package by.nexer.travelassistant.controller.OpenAPI;

import by.nexer.travelassistant.model.entity.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


import java.util.List;

@Tag(name = "Users", description = "The Users Api")
public interface UserApi {
    @Operation(
            summary = "Fetch all users",
            description = "Retrieve all user entities and their data from the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<UserEntity>> getUsers();

    @Operation(
            summary = "Fetch user by id",
            description = "Retrieve a user entity and its data by ID from the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<UserEntity> getUser(@Parameter(
            description = "ID of user to be retrieved",
            required = true) Long id);

    @Operation(
            summary = "Create user",
            description = "create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<UserEntity> createUser(UserEntity user);

    @Operation(
            summary = "Update user by id",
            description = "Update an existing user entity with the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<UserEntity> updateUser(@Parameter(
            description = "ID of user to be retrieved",
            required = true) Long id, UserEntity body);

    @Operation(
            summary = "Delete user by id",
            description = "Delete a user entity with the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<String> deleteUser(@Parameter(
            description = "ID of user to be retrieved",
            required = true) Long id);
}
