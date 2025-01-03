package de.telran.onlineshop.mapper;


import de.telran.onlineshop.dto.OrderItemsDto;
import de.telran.onlineshop.entity.OrderItemsEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemsMapper {

    private final ModelMapper modelMapper;

    public OrderItemsDto converToOrderItemsDto(OrderItemsEntity orderItemsEntity) {
        OrderItemsDto orderItemsDto = null;
        if (orderItemsEntity != null)
            orderItemsDto = modelMapper.map(orderItemsEntity, OrderItemsDto.class);
        return orderItemsDto;
    }

    public OrderItemsEntity convertToOrderItemsEntity(OrderItemsDto orderItemsDto) {
        OrderItemsEntity orderItemsEntity = modelMapper.map(orderItemsDto, OrderItemsEntity.class);
        return orderItemsEntity;
    }
}
