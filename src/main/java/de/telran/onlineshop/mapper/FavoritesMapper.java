package de.telran.onlineshop.mapper;

import de.telran.onlineshop.dto.FavoritesDto;
import de.telran.onlineshop.entity.FavoritesEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FavoritesMapper {

    private final ModelMapper modelMapper;

    public FavoritesDto convertToFavoritesDto(FavoritesEntity favoritesEntity) {
        FavoritesDto favoritesDto = modelMapper.map(favoritesEntity, FavoritesDto.class); //автомат
        favoritesDto.setUser(null);
        return favoritesDto;
    }

    public FavoritesEntity convertToFavoritesEntity(FavoritesDto favoritesDto) {
        FavoritesEntity favoritesEntity = modelMapper.map(favoritesDto, FavoritesEntity.class);
        return favoritesEntity;
    }
}
