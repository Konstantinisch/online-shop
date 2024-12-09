package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoriesRepositoryTest {

    @Autowired
    private CategoriesRepository categoriesRepositoryTest;

    private static final String NAME_TEST = "Test";
    private static CategoriesEntity categoriesEntityNewTest;

    @BeforeAll
    static void setStart() {
        categoriesEntityNewTest = new CategoriesEntity(null, NAME_TEST);
        System.out.println("Execute setStart! (before execute ALL tests)");
    }

    @AfterAll
    static void setEnd() {
        System.out.println("Execute setEnd! (after execute All tests)");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Execute setUp! (before each test)");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Execute tearDown! (after each test)");
    }

    @Test
    void findAllTest() {
        List<CategoriesEntity> categoriesTest = categoriesRepositoryTest.findAll();
        assertNotNull(categoriesTest);

    }

    @Test
    void insertTest() {
        String nameExpected = NAME_TEST;
        CategoriesEntity categoriesTest = categoriesEntityNewTest;

        CategoriesEntity categoriesActual = categoriesRepositoryTest.save(categoriesTest);

        assertNotNull(categoriesActual);
        assertTrue(categoriesActual.getCategoryId() != null);
        assertEquals(nameExpected, categoriesActual.getName());

    }


    @Test
    void updateTest() {
        //when

        CategoriesEntity categoriesTest =categoriesEntityNewTest;
        CategoriesEntity categoriesInsert = categoriesRepositoryTest.save(categoriesEntityNewTest);
        assertNotNull(categoriesInsert);
        assertTrue(categoriesInsert.getCategoryId() != null);
        assertEquals(NAME_TEST, categoriesInsert.getName());

        String nameExpected = "Test";

        //test
        categoriesInsert.setName(nameExpected);
        CategoriesEntity categoriesActual = categoriesRepositoryTest.save(categoriesInsert);

        //assert
        assertNotNull(categoriesInsert);
        assertEquals(nameExpected, categoriesInsert.getName());

    }

    @Test
    void findByNameTest() {

        //when

        CategoriesEntity categoriesInsert = categoriesRepositoryTest.save(categoriesEntityNewTest);
        assertNotNull(categoriesInsert);
        assertTrue(categoriesInsert.getCategoryId() != null);
        assertEquals(NAME_TEST, categoriesInsert.getName());

        //run
        String nameExpected = "Test";
        CategoriesEntity categoriesActual = categoriesRepositoryTest.findByName(nameExpected);

        //assert
        assertNotNull(categoriesActual);
        assertEquals(nameExpected, categoriesActual.getName());

        //podchischaem ?

    }

    @Test
    void deleteTest() {
        //when

        CategoriesEntity categoriesInsert = categoriesRepositoryTest.save(categoriesEntityNewTest);
        assertNotNull(categoriesInsert);
        assertTrue(categoriesInsert.getCategoryId() != null);
        assertEquals(NAME_TEST, categoriesInsert.getName());

        //run
        //1 variante delete
        Long idTest = categoriesInsert.getCategoryId();
        categoriesRepositoryTest.deleteById(idTest);

        //2 variante delete
        categoriesRepositoryTest.delete(categoriesInsert);

        //assert
        // 1 variante
        Optional<CategoriesEntity> categoriesActualOptional = categoriesRepositoryTest.findById(idTest);
        assertFalse(categoriesActualOptional.isPresent());

        //2 variante
        CategoriesEntity categoriesActual = categoriesRepositoryTest.findById(idTest).orElse(null);
        assertNull(categoriesActual);
    }



    @Test
    void findByNameNative() {
        //when

        CategoriesEntity categoriesExpected = generateTestData();


        //run
        String nameExpected =categoriesExpected.getName();
        CategoriesEntity categoriesActual = categoriesRepositoryTest.findByNameNative(nameExpected);

        //assert
        assertNotNull(categoriesActual);
        assertEquals(nameExpected, categoriesActual.getName());

        //podchischaem ?

    }

    private CategoriesEntity generateTestData(){
        CategoriesEntity categoriesInsert = categoriesRepositoryTest.save(categoriesEntityNewTest);
        assertNotNull(categoriesInsert);
        assertTrue(categoriesInsert.getCategoryId() != null);
        assertEquals(NAME_TEST, categoriesInsert.getName());
        return categoriesInsert;
    }
}