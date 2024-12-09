package de.telran.onlineshop.service;

import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.repository.FavoritesRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoritesService {

    private final FavoritesRepository favoritesRepository;
    private final ProductsRepository productsRepository;

}
