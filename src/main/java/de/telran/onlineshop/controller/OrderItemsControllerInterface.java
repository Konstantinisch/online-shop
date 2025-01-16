package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.OrderItemsDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "OrderItems Endpoint", description = "Endpoint for working with users", externalDocs =
@ExternalDocumentation(description = "Link for external documentation", url = "http://amazon.de"))
public interface OrderItemsControllerInterface {

    @Operation(summary = "All OrderItems", description = "To get all OrderItems")
    public List<OrderItemsDto> getAllOrderItems();

    @Operation(summary = "Find OrderItems by Id", description = "Opportunity to find " +
            "an OrderItems by Id")
    public OrderItemsDto getOrderItemsById(
            @Parameter(description = "Identifier", required = true, example = "1")
            @PathVariable Long id);

    @Operation(summary = "Update an OrderItem", description = "Possibility to update an old OrderItem")
    public OrderItemsDto updateOrderItems(@RequestBody OrderItemsDto orderItemsDto);

    @Operation(summary = "Insert a new OrderItem", description = "Chance to create and insert to DB a new OrderItem")
    public OrderItemsDto insertOrderItems(@RequestBody OrderItemsDto orderItemsDto);

    @Operation(summary = "Delete an OrderItem", description = "Find and delete an OrderItem")
    public void deleteOrderItems(@PathVariable Long id);
}
