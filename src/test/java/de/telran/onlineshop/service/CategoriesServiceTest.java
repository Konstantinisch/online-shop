package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.mapper.Mappers;
import de.telran.onlineshop.repository.CategoriesRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoriesServiceTest {

    @Mock
    private CategoriesRepository categoriesRepositoryMock;

    @Mock
    private ProductsRepository productsRepositoryMock;

    @Mock
    private Mappers mapperMock;

    @InjectMocks
    private CategoriesService categoriesServiceTest;

    private CategoriesEntity categoriesEntityTest1;

    private CategoryDto categoryDtoTest1;

    @BeforeEach
    void setUp() {

        categoriesEntityTest1 = new CategoriesEntity(
              1L,
              "Autos",
              new HashSet<ProductsEntity>()
        );

        categoryDtoTest1 = new CategoryDto(
              1L,
              "Autos"
        );
    }

//    @Test
//    void getAllCategories() {
//        CategoriesEntity categoriesEntityTest2 = new CategoriesEntity(
//                2L,
//                "Airplanes",
//                new HashSet<ProductsEntity>()
//        );
//
//        CategoryDto categoryDtoTest2 = new CategoryDto(
//             2L,
//             "Airplanes"
//        );
//
//        when(categoriesRepositoryMock.findAll()).thenReturn(List.of(categoriesEntityTest1, categoriesEntityTest2));
//        when(mapperMock.convertToCategoriesDto(categoriesEntityTest1)).thenReturn(categoryDtoTest1);
//        when(mapperMock.convertToCategoriesDto(categoriesEntityTest2)).thenReturn(categoryDtoTest2);
//
//        List<CategoryDto> actualCategoriesDtoList = categoriesServiceTest.getAllCategories();
//
//        assertNotNull(actualCategoriesDtoList);
//        assertTrue(actualCategoriesDtoList.size() > 0);
//        assertEquals(2, actualCategoriesDtoList.size());
////        assertEquals(2, actualCategoriesDtoList.get(0).getCategoryID());
////        assertEquals(categoryDtoTest2, actualCategoriesDtoList.get(0));
//        verify(categoriesRepositoryMock).findAll();
//        verify(mapperMock, times(2)).convertToCategoriesDto(any(CategoriesEntity.class));
//
//    }

    @Test
    void getAllCategories() {
        // Мокаем репозиторий и маппер
        CategoriesEntity categoriesEntityTest2 = new CategoriesEntity(2L, "Airplanes", new HashSet<>());
        CategoryDto categoryDtoTest2 = new CategoryDto(2L, "Airplanes");

        when(categoriesRepositoryMock.findAll()).thenReturn(List.of(categoriesEntityTest1, categoriesEntityTest2));
        when(mapperMock.convertToCategoriesDto(categoriesEntityTest1)).thenReturn(categoryDtoTest1);
        when(mapperMock.convertToCategoriesDto(categoriesEntityTest2)).thenReturn(categoryDtoTest2);

        // Вызываем метод сервиса
        List<CategoryDto> actualCategoriesDtoList = categoriesServiceTest.getAllCategories();

        // Проверяем результаты
        assertNotNull(actualCategoriesDtoList);
        assertEquals(2, actualCategoriesDtoList.size());
        verify(categoriesRepositoryMock).findAll(); // Проверяем, что был вызван репозиторий
        verify(mapperMock, times(2)).convertToCategoriesDto(any(CategoriesEntity.class)); // Проверяем, что метод маппера был вызван дважды
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void getCategoryByName() {
    }

    @Test
    void createCategories() {
    }

    @Test
    void updateCategories() {
    }

    @Test
    void deleteCategories() {
    }
}