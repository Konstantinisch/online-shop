package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.service.CategoriesService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")

public class CategoriesController implements CategoriesControllerInterface {
    //@Autowired - иньекция через value (не рекомендуемая из-за Reflection)
    private CategoriesService categoryService;

    //@Autowired - иньекция через конструктор (рекомендуемая !!!), авто аннотирование с версии 3.0
    public CategoriesController(CategoriesService categoryService) {
        this.categoryService = categoryService;
    }

    // @Autowired - иньекция через сеттер (обязательно использовать аннотацию)
    public void setCategoryService(CategoriesService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping  //select
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @GetMapping(value = "/find/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) throws FileNotFoundException { ///categories/find/3
        return categoryService.getCategoryById(id);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    public CategoryDto getCategoryByName(@RequestParam String name) { ///categories/get?name=Other,k=2
        return categoryService.getCategoryByName(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Jackson
    public boolean createCategories(@RequestBody @Valid CategoryDto newCategory) { //insert
        return categoryService.createCategories(newCategory);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public CategoryDto updateCategories(@RequestBody @Valid CategoryDto updCategory) { //update
        return categoryService.updateCategories(updCategory);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteCategories(@PathVariable Long id) { //delete
        categoryService.deleteCategories(id);
    }

    // альтернативная обработка ошибочной ситуации Exception
    @ExceptionHandler({IllegalArgumentException.class, FileNotFoundException.class})
    public ResponseEntity handleTwoException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Categories Controller" + exception.getMessage());
    }

//    // альтернативная обработка ошибочной ситуации Exception
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity handleException(Exception exception) {
//        return ResponseEntity
//                .status(HttpStatus.I_AM_A_TEAPOT)
//                .body("Извините, что-то пошло не так. Попробуйте позже!" + exception.getMessage());
//    }

}