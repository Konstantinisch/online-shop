package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.ProductsDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Products", description = "Endpoint for working with users",
        externalDocs = @ExternalDocumentation(description = "Link for external documentation",
        url = "http://ebay-kleinanzeigen.de"))
public interface ProductsControllerInterface {

    @Operation(summary = "All Products", description = "Get list of all Products")
    public List<ProductsDto> getAllProducts();

    @Operation(summary = "Find by Id", description = "Possibility to find a Product by Id")
    public ProductsDto getProductById(
            @Parameter(description = "Identifier", required = true, example = "1")
            @PathVariable Long id);

    @Operation(summary = "Update a Product", description = "Opportunity to update an old Product")
    public ProductsDto updateProduct(@RequestBody @Valid ProductsDto productsDto);

    @Operation(summary = "Create a new Product", description = "Possibility to create" +
            " a new Product and insert it to DB")
    public ProductsDto insertProduct(@RequestBody @Valid ProductsDto productsDto);

    @Operation(summary = "Delete a Product from DB", description = "Find by Id and " +
            "delete a Product from DB")
    public void deleteProduct(@PathVariable Long id);
}
