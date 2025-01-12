package de.telran.onlineshop.integration;


import de.telran.onlineshop.entity.AddressEntity;
import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.entity.enums.Role;
import de.telran.onlineshop.repository.CategoriesRepository;
import de.telran.onlineshop.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@ActiveProfiles(profiles = { ""})//sapusk vsego kontejnera Spring
public class UsersIntegrationTest {

    @Autowired
    private MockMvc mockMvc; // для иммитации запросов пользователей

    @MockBean
    private UsersRepository usersRepositoryMock;



    @Test
    void getAllUsersTest() throws Exception {
        when(usersRepositoryMock.findAll()).thenReturn(List.of(new UsersEntity(
                1L,
                "Vasja Pupkin",
                "rrr@web.de",
                "+491601234567",
                "Password1",
                Role.CLIENT,
                new CartEntity(),
                new HashSet<FavoritesEntity>(),
                new HashSet<AddressEntity>()

        )));
        this.mockMvc.perform(get("/users"))
                .andDo(print()) //печать лога вызова
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$..userID").exists())
//                .andExpect(jsonPath("$..name").exists());

    }




}
