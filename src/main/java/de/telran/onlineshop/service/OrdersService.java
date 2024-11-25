package de.telran.onlineshop.service;

//import de.telran.onlineshop.model.Orders;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.OrdersEntity;
import de.telran.onlineshop.model.Category;
import de.telran.onlineshop.model.Order;
import de.telran.onlineshop.model.OrdersEnum;
import de.telran.onlineshop.model.User;
import de.telran.onlineshop.repository.OrdersRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @PostConstruct
    void init() {
        OrdersEntity ordersEntity1 = new OrdersEntity(1, 2, new Timestamp(System.currentTimeMillis()),
                "Fisherstreet", 4917, "per Car",
                OrdersEnum.ORDERED, new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(ordersEntity1);
        OrdersEntity ordersEntity2 = new OrdersEntity(2,3,new Timestamp(System.currentTimeMillis()),
                "Bananastreet", 4535, "per Car",
                OrdersEnum.DELIVERED, new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(ordersEntity2);
    }

    public List<Order> getAllOrders () {
        List<OrdersEntity> ordersEntities = ordersRepository.findAll();
        return ordersEntities.stream()
                .map(entity -> new Order(entity.getOrderId(), entity.getUserId(),entity.getCreatedAt(),
                        entity.getDeliveryAddress(), entity.getContactPhone(), entity.getDeliveryMethod(),
                        entity.getStatus(), entity.getUpdatedAt()))
                .collect(Collectors.toList());
    }




}
