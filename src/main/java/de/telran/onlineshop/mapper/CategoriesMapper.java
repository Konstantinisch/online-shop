//package de.telran.onlineshop.mapper;
//
//import de.telran.onlineshop.dto.CategoryDto;
//import de.telran.onlineshop.entity.CategoriesEntity;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class CategoriesMapper {
//
//    private final ModelMapper modelMapper;
//
//    public CategoryDto convertToCategoriesDto(CategoriesEntity categoriesEntity) {
//        CategoryDto categoryDto = modelMapper.map(categoriesEntity, CategoryDto.class);
//        return categoryDto;
//    }
//
//    public CategoriesEntity convertToCategoriesEntity(CategoryDto categoryDto) {
//        CategoriesEntity categoriesEntity = modelMapper.map(categoryDto, CategoriesEntity.class);
//        return categoriesEntity;
//    }
//}
