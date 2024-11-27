package de.telran.onlineshop.service;

//import de.telran.onlineshop.model.Orders;

import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.OrdersEntity;
import de.telran.onlineshop.dto.OrderDto;
import de.telran.onlineshop.dto.OrdersEnum;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.repository.OrdersRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @PostConstruct
    void init() {
        OrdersEntity ordersEntity1 = new OrdersEntity(null, 2, new Timestamp(System.currentTimeMillis()),
                "Fish street", 4917, "per Car",
                OrdersEnum.ORDERED, new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(ordersEntity1);
        OrdersEntity ordersEntity2 = new OrdersEntity(null,3,new Timestamp(System.currentTimeMillis()),
                "Banana street", 4535, "per Car",
                OrdersEnum.DELIVERED, new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(ordersEntity2);
    }

    public List<OrderDto> getAllOrders () {
        List<OrdersEntity> ordersEntities = ordersRepository.findAll();
        return ordersEntities.stream()
                .map(entity -> new OrderDto(entity.getOrderId(), entity.getUserId(),entity.getCreatedAt(),
                        entity.getDeliveryAddress(), entity.getContactPhone(), entity.getDeliveryMethod(),
                        entity.getStatus(), entity.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    public OrderDto getOrderById(Long id) {
        OrdersEntity ordersEntity = ordersRepository.findById(Math.toIntExact(id)).orElse(new OrdersEntity());
        return new OrderDto(ordersEntity.getOrderId(), ordersEntity.getUserId(), ordersEntity.getCreatedAt(),
                ordersEntity.getDeliveryAddress(), ordersEntity.getContactPhone(), ordersEntity.getDeliveryMethod(),
                ordersEntity.getStatus(), ordersEntity.getUpdatedAt());
    }


    public boolean createOrders( OrderDto newOrder) { //insert
        OrdersEntity createOrderEntity = new OrdersEntity(null, newOrder.getUserID(), newOrder.getCreatedAt(),
                newOrder.getDeliveryAddress(), newOrder.getContactPhone(), newOrder.getDeliveryMethod(),
                newOrder.getStatus(), newOrder.getUpdatedAt());
        OrdersEntity returnOrderEntity = ordersRepository.save(createOrderEntity);


        return createOrderEntity.getOrderId() != null;
    }

    public OrderDto updateOrders(OrderDto updOrder) { //update
        OrdersEntity createOrderEntity = new OrdersEntity(null, updOrder.getUserID(), updOrder.getCreatedAt(),
                updOrder.getDeliveryAddress(), updOrder.getContactPhone(), updOrder.getDeliveryMethod(),
                updOrder.getStatus(), updOrder.getUpdatedAt());
        OrdersEntity returnOrderEntity = ordersRepository.save(createOrderEntity);
        //transformiruem dannie is Entity v DTO i vosvraschaem polsovatelju

        return new OrderDto(returnOrderEntity.getOrderId(), returnOrderEntity.getUserId(), returnOrderEntity.getCreatedAt(),
                returnOrderEntity.getDeliveryAddress(), returnOrderEntity.getContactPhone(), returnOrderEntity.getDeliveryMethod(),
                returnOrderEntity.getStatus(), returnOrderEntity.getUpdatedAt());
    }

    public void deleteOrders( Long id) { //delete
        //categoriesRepository.deleteById(id); // first variant realisazii menee informativno

        OrdersEntity orders = ordersRepository.findById(Math.toIntExact(id)).orElse(null);
        if (orders == null) {
            throw new RuntimeException("Net takogo objecta s id =" + id);
        } else {
            ordersRepository.delete(orders);
        }

    }




}
