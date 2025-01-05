package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.ProductsDto;
import de.telran.onlineshop.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductsDto> getAllProducts() {
        return productsService.getAllProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public ProductsDto getProductById(@PathVariable Long id) {
        return productsService.getProductById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ProductsDto updateProduct(@RequestBody ProductsDto productsDto) {
       return productsService.updateProduct(productsDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ProductsDto insertProduct(@RequestBody ProductsDto productsDto) {
       return productsService.insertProduct(productsDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }

}
