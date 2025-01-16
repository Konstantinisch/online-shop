package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.OrdersDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Orders Endpoint", description = "Endpoint for working with users",
        externalDocs = @ExternalDocumentation(description = "Link for external documentation",
        url = "http://ebay.de"))
public interface OrdersControllerInterface {

    @Operation(summary = "All Orders", description = "Possibility to get a List of all Orders")
    public List<OrdersDto> getAllOrders ();

    @Operation(summary = "Find by Id", description = "Opportunity to find an Order by Id")
    public ResponseEntity<OrdersDto> getOrderById(
            @Parameter(description = "Unique key of Order", required = true, example = "1")
            @PathVariable Long id);

    @Operation(summary = "Insert a new Order", description = "Possibility to create a new " +
            "Order and put it to Database")
    public boolean createOrders(@RequestBody @Valid OrdersDto newOrder);

    @Operation(summary = "Update an Order", description = "Opportunity to update an old Order")
    public OrdersDto updateOrder(@RequestBody @Valid OrdersDto updOrder);

    @Operation(summary = "Delete an Order from DB", description = "Find and delete an old Order from DB")
    public void deleteOrders(@PathVariable Long id);
}
