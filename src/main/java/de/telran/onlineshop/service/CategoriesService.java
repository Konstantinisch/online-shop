package de.telran.onlineshop.service;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.repository.CategoriesRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // добавится конструктор, в который включатся все private final характеристики
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    private Random random1; // imja peremennoj sovpalo imenem metoda Bean

    @Autowired
    //@Qualifier("taskRandom2")
    @Qualifier("random2")//utochnenie imeni Bean , kogda est neskolko teh ze tipov dannih
    private Random otherRandom;

    //Poisk Bean 1. po tipu dannih, 2. po imeni 3. po znacheniju v @Qualifier

    private List<CategoryDto> categoryList;


    @PostConstruct
    void init() {
        CategoriesEntity category1 = new CategoriesEntity(null, "Продукты");
        category1 = categoriesRepository.save(category1);
        CategoriesEntity category2 = new CategoriesEntity(null, "Быт.химия");
        category2 = categoriesRepository.save(category2);
        CategoriesEntity category3 = new CategoriesEntity(null, "Радиотехника");
        category3 = categoriesRepository.save(category3);
        CategoriesEntity category4 = new CategoriesEntity(null, "Игрушки");
        categoriesRepository.save(category4);
        CategoriesEntity category5 = new CategoriesEntity(null, "Одежда");
        categoriesRepository.save(category5);
        CategoriesEntity category6 = new CategoriesEntity(null, "Other");
        category6 = categoriesRepository.save(category6);

        //sluchaino menjaem kakuju to categoriju
        //Long idUpdate = taskRandom1.nextLong(6);
        Long idUpdate = random1.nextLong(5) + 1;
        CategoriesEntity updateCategory = new CategoriesEntity(idUpdate, "Другие");
        categoriesRepository.save(updateCategory);


        System.out.println("Выполняем логику при создании объекта " + this.getClass().getName());


    }

    // rabotaet s DB
    public List<CategoryDto> getAllCategories() {
        List<CategoriesEntity> categoriesEntities = categoriesRepository.findAll();
        return categoriesEntities.stream()
                .map(entity -> new CategoryDto(entity.getCategoryId(), entity.getName()))
                .collect(Collectors.toList());
    }

//    public List<Category> getAllCategoriesCycle() {
//        List<CategoriesEntity> categoriesEntities = categoriesRepository.findAll();
//        List<Category> categories = new ArrayList<>();
//        for (int i = 0; i < categoriesEntities.size(); i++) {
//            categories.add(new Category(categoriesEntities.get(i).getCategoryId(),
//                    categoriesEntities.get(i).getName()));
//        }
//        return categories;
//    }


    public CategoryDto getCategoryById( Long id) { ///categories/find/3

        CategoriesEntity categoriesEntity = categoriesRepository.findById(id).orElse(new CategoriesEntity());
        return new CategoryDto(categoriesEntity.getCategoryId(), categoriesEntity.getName());

//        return categoryList.stream()
//                .filter(category -> category.getCategoryID() == id)
//                .findFirst()
//                .orElse(null);
    }

    public CategoryDto getCategoryByName(String name) {///categories/get?name=Other,k=2
        //CategoriesEntity categoriesEntity = categoriesRepository.findByName(name);//use OQL
        CategoriesEntity categoriesEntity = categoriesRepository.findByNameNative(name); //use native SQL

        return new CategoryDto(categoriesEntity.getCategoryId(), categoriesEntity.getName());

//        return categoryList.stream()
//                .filter(category -> category.getName().equals(name))
//                .findFirst()
//                .orElse(null);
    }

    public boolean createCategories( CategoryDto newCategory) { //insert
        CategoriesEntity createCategoryEntity = new CategoriesEntity(null, newCategory.getName());
        CategoriesEntity returnCategoryEntity = categoriesRepository.save(createCategoryEntity);


        return returnCategoryEntity.getCategoryId() != null;
    }

    public CategoryDto updateCategories(CategoryDto updCategory) { //update
        CategoriesEntity createCategoryEntity = new CategoriesEntity(updCategory.getCategoryID(), updCategory.getName());
        CategoriesEntity returnCategoryEntity = categoriesRepository.save(createCategoryEntity);
       //transformiruem dannie is Entity v DTO i vosvraschaem polsovatelju

        return new CategoryDto(returnCategoryEntity.getCategoryId(), returnCategoryEntity.getName());
    }

    public void deleteCategories( Long id) { //delete
        //categoriesRepository.deleteById(id); // first variant realisazii menee informativno

        CategoriesEntity categories = categoriesRepository.findById(id).orElse(null);
        if(categories==null){
            throw new RuntimeException("Net takogo objecta s id =" +id);
        }else {
            categoriesRepository.delete(categories);
        }


//        Iterator<CategoryDto> it = categoryList.iterator();
//        while (it.hasNext()) {
//            CategoryDto current = it.next();
//            if (current.getCategoryID() == id) {
//                it.remove();
//            }
//        }
    }

    @PreDestroy
    void destroy() {
        categoryList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом " + this.getClass().getName());
    }
}