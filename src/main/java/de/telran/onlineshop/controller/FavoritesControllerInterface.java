package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.FavoritesDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Favorites", description = "Endpoint for working with Favorites und giving it to users",
externalDocs = @ExternalDocumentation(description = "Link for external documentation",
        url = "http://apple.de"))
public interface FavoritesControllerInterface {

    @Operation(summary = "All Favorites", description = "Give a possibility to get all Favorites")
    public List<FavoritesDto> getAllFavorites();

    @Operation(summary = "Find Favorite by ID", description = "Possibility to find a Favorite by Id")
    public FavoritesDto getFavoritesById(
            @Parameter(description = "Identifier", required = true, example = "1")
            @PathVariable Long id);

    @Operation(summary = "Update of old Favorite", description = "Give us a Opportunity to replace a some" +
            " Data of Favorite ")
    public FavoritesDto updateFavorites(@RequestBody @Valid FavoritesDto favoritesDto);

    @Operation(summary = "Insert of new Favorite", description = "The Opportunity to create a new Favorite")
    public FavoritesDto insertFavorites(@RequestBody @Valid FavoritesDto favoritesDto);

    @Operation(summary = "Delete of Favorite", description = "The way to delete a Favorite")
    public void deleteFavorites(@PathVariable Long id);

}
