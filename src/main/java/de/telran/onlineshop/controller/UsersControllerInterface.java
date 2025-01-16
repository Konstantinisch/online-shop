package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.UserDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileNotFoundException;
import java.util.List;

@Tag(name = "Users Endpoint", description = "Endpoint for working with users",
        externalDocs = @ExternalDocumentation(description = "Link for external documentation",
                url = "http://wetter.de"))
public interface UsersControllerInterface {

    @Operation(summary = "All Users", description = "Get list of all Users")
    public ResponseEntity<List<UserDto>> getAllUsers();

    @Operation(summary = "Find by Id", description = "Opportunity to find an User by Id")
    public ResponseEntity<UserDto> getUserById(
            @Parameter(description = "Identifier", required = true, example = "1")
            @PathVariable Long id) throws FileNotFoundException;

    @Operation(summary = "Update an User", description = "Possibility to update an old User")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user);

    @Operation(summary = "Insert an User", description = "Possibility to create and " +
            "insert a new User to DB")
    public ResponseEntity<UserDto> insertUsers(@RequestBody UserDto userDto);

    @Operation(summary = "Delete an User", description = "Find by Id and delete an User from DB")
    public void deleteUsersById(@PathVariable Long id);
}
