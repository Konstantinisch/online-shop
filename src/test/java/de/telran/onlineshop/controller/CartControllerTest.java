package de.telran.onlineshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.onlineshop.dto.CartDto;
import de.telran.onlineshop.service.CartService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@WebMvcTest(CartController.class)
class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartServiceMock;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getCartByID() throws Exception {
        when(cartServiceMock.getCartByID(anyInt())).thenReturn(new CartDto(1L, 4));

        this.mockMvc.perform(get("/cart/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..cartID").exists())
                .andExpect(jsonPath("$..cartID").value(1))
                .andExpect(jsonPath("$..userID").value(4));
    }


    @Test
    void createCart() throws Exception {
        when(cartServiceMock.createCart(any(CartDto.class))).thenReturn(new CartDto(1L,2));
        this.mockMvc.perform(post("/cart/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        """
                        {
                            "cartID": null,
                            "userID": 2
                        }
                        """
                ))
                .andDo(print())
                .andExpect(status().isCreated());

    }



    @Test
    void updateCart() throws Exception {
        CartDto inputCart = new CartDto(1L,2);
        CartDto expectedCart = inputCart;
        when(cartServiceMock.updateCart(inputCart)).thenReturn(expectedCart);
        this.mockMvc.perform(put("/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputCart)))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.cartID").exists())
                .andExpect(jsonPath("$.cartID").value(expectedCart.getCartID()))
                .andExpect(jsonPath("$.userID").value(expectedCart.getUserID()));

    }

    @Test
    void deleteCart() throws Exception {
        Long inputId = 1L;

        this.mockMvc.perform(delete("/cart/{id}", inputId))
                .andDo(print())
                .andExpect(status().isOk());

        verify(cartServiceMock).deleteCart(inputId);
    }


}


