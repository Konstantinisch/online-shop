package de.telran.onlineshop.mapper;

import de.telran.onlineshop.dto.OrdersDto;
import de.telran.onlineshop.entity.OrdersEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ModelMapper modelMapper;
    private final UserMapper userMapper;



    public OrdersDto convertToOrdersDto (OrdersEntity ordersEntity) {
        modelMapper.typeMap(OrdersEntity.class, OrdersDto.class)
                .addMappings(mapper -> mapper.skip(OrdersDto::setContactPhone));
        OrdersDto ordersDto = modelMapper.map(ordersEntity, OrdersDto.class);
        return ordersDto;
    }

    public OrdersEntity convertToOrdersEntity(OrdersDto ordersDto) {
        OrdersEntity ordersEntity = modelMapper.map(ordersDto, OrdersEntity.class);
        return ordersEntity;
    }
}
