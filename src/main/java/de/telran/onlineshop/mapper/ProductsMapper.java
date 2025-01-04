//package de.telran.onlineshop.mapper;
//
//import de.telran.onlineshop.dto.ProductsDto;
//import de.telran.onlineshop.entity.ProductsEntity;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class ProductsMapper {
//
//    private final ModelMapper modelMapper;
//
//    public ProductsDto convertToProductsDto(ProductsEntity productsEntity) {
//        modelMapper.typeMap(ProductsEntity.class, ProductsDto.class)
//                .addMappings(mapper -> mapper.skip(ProductsDto::setPrice));
//        ProductsDto productsDto = modelMapper.map(productsEntity, ProductsDto.class);
//        return productsDto;
//    }
//
//    public ProductsEntity convertToProductsEntity(ProductsDto productsDto) {
//        ProductsEntity productsEntity = modelMapper.map(productsDto, ProductsEntity.class);
//        return productsEntity;
//    }
//}
