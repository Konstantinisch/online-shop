package de.telran.onlineshop.service;

import de.telran.onlineshop.configure.MapperUtil;
import de.telran.onlineshop.dto.FavoritesDto;
import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.mapper.Mappers;
import de.telran.onlineshop.repository.FavoritesRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import de.telran.onlineshop.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoritesService {

    private final FavoritesRepository favoritesRepository;
    private final ProductsRepository productsRepository;
    private final UsersRepository usersRepository;
    private final Mappers mappers;

    public List<FavoritesDto> getAllFavorites() {
        List<FavoritesEntity> favoritesEntitiesList = favoritesRepository.findAll();
        List<FavoritesDto> favoritesDtoList = MapperUtil.convertList(favoritesEntitiesList,
                mappers::convertToFavoritesDto);
        return favoritesDtoList;
    }

    public FavoritesDto getFavoritesById(Long id) {
        FavoritesEntity favoritesEntity = favoritesRepository.findById(id).orElse(new FavoritesEntity());
        FavoritesDto favoritesDto = mappers.convertToFavoritesDto(favoritesEntity);
        return favoritesDto;
    }

    public FavoritesDto updateFavorites(FavoritesDto favoritesDto) {
        FavoritesEntity favoritesEntity = mappers.convertToFavoritesEntity(favoritesDto);
        FavoritesEntity returnFavorites = favoritesRepository.save(favoritesEntity);
        return mappers.convertToFavoritesDto(returnFavorites);
    }

    public FavoritesDto insertFavorites(FavoritesDto favoritesDto) {
        FavoritesEntity favoritesEntity = mappers.convertToFavoritesEntity(favoritesDto);
        favoritesEntity.setFavoriteId(null);
        FavoritesEntity savedFavoritesEntity = favoritesRepository.save(favoritesEntity);
        return mappers.convertToFavoritesDto(savedFavoritesEntity);
    }

    public void deleteFavorites(Long id) {
        FavoritesEntity favoritesEntity = favoritesRepository.findById(id).orElse(new FavoritesEntity());
        if (favoritesEntity == null) {
            throw new RuntimeException("not exist");
        } else {
            favoritesRepository.delete(favoritesEntity);
        }
    }

}
