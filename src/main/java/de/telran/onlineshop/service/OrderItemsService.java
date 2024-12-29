package de.telran.onlineshop.service;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.OrderItemsEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.repository.OrderItemsRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderItemsService {

    private final OrderItemsRepository orderItemsRepository;
    private final ProductsRepository productsRepository;

    //@PostConstruct
    void init () {

        ProductsEntity products1 = new ProductsEntity(null,"Pulver","Weiss",3.4,
                "http/www.",4.7, Timestamp.valueOf(LocalDateTime.now()),null,new CategoriesEntity(null,"Milch"),null );
        products1 = productsRepository.save(products1);
        OrderItemsEntity orderItems1 = new OrderItemsEntity(3, 6, 4,
                777,products1 );
        orderItemsRepository.save(orderItems1);

    }
}
