package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CategoryDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;
import java.util.List;

@Tag(name = "Categories", description = "Controller for working with products",
        externalDocs = @ExternalDocumentation(
                description = "Link for external documentation",
                url = "http://example.com/"
        )
)
public interface CategoriesControllerInterface {
    @Operation(
            summary = "All Categories",
            description = "Позволяет get All Categories of products"
    )
    public List<CategoryDto> getAllCategories();


    @Operation(
            summary = "Find ID",
            description = "Позволяет find ID Categories of products"
    )
    public CategoryDto getCategoryById(
            @Parameter(description = "Identificator", required = true, example = "1")
            @PathVariable Long id) throws FileNotFoundException;

    @Hidden
    public void deleteCategories(@PathVariable Long id);
}
