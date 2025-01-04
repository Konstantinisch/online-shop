package de.telran.onlineshop.service;

import de.telran.onlineshop.configure.MapperUtil;
import de.telran.onlineshop.dto.OrderItemsDto;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.OrderItemsEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.mapper.Mappers;
import de.telran.onlineshop.repository.OrderItemsRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsService {

    private final OrderItemsRepository orderItemsRepository;
    private final ProductsRepository productsRepository;
    private final Mappers mappers;

    //@PostConstruct
    void init () {

        ProductsEntity products1 = new ProductsEntity(null,"Pulver","Weiss",3.4,
                "http/www.",4.7, Timestamp.valueOf(LocalDateTime.now()),null,new CategoriesEntity(null,"Milch"),null );
        products1 = productsRepository.save(products1);
        OrderItemsEntity orderItems1 = new OrderItemsEntity(3, 6, 4,
                777,products1 );
        orderItemsRepository.save(orderItems1);

    }

    public List<OrderItemsDto> getAllOrderItems() {
       List<OrderItemsEntity> orderItemsEntity = orderItemsRepository.findAll();
       List<OrderItemsDto> orderItemsDtoList = MapperUtil.convertList(orderItemsEntity, mappers::converToOrderItemsDto);
       return orderItemsDtoList;
    }

    public OrderItemsDto getOrderItemsById(Long id) {
        OrderItemsEntity orderItemsEntity = orderItemsRepository.findById(id).orElse(new OrderItemsEntity());
        OrderItemsDto orderItemsDto = mappers.converToOrderItemsDto(orderItemsEntity);
        return orderItemsDto;
    }

    public OrderItemsDto updateOrderItems(OrderItemsDto orderItemsDto) {
        OrderItemsEntity orderItemsEntity = mappers.convertToOrderItemsEntity(orderItemsDto);
        OrderItemsEntity returnOrderItems = orderItemsRepository.save(orderItemsEntity);
        return mappers.converToOrderItemsDto(returnOrderItems);
    }
}
