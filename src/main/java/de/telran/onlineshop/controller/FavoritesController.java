package de.telran.onlineshop.controller;


import de.telran.onlineshop.dto.FavoritesDto;
import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.service.FavoritesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/favorites")
@RequiredArgsConstructor
public class FavoritesController {

    private final FavoritesService favoritesService;

    @GetMapping
    public List<FavoritesDto> getAllFavorites() {
        return favoritesService.getAllFavorites();
    }

    @GetMapping(value = "/{id}")
    public FavoritesDto getFavoritesById(@PathVariable Long id) {
        return favoritesService.getFavoritesById(id);
    }

    @PutMapping
    public FavoritesDto updateFavorites(@RequestBody @Valid FavoritesDto favoritesDto) {
        return favoritesService.updateFavorites(favoritesDto);
    }

    @PostMapping
    public FavoritesDto insertFavorites(@RequestBody @Valid FavoritesDto favoritesDto) {
        return favoritesService.insertFavorites(favoritesDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFavorites(@PathVariable Long id) {
        favoritesService.deleteFavorites(id);
    }
}
