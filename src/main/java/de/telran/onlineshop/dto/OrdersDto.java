package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.Objects;

@Schema(description = "Data for users")
public class OrdersDto {
    @PositiveOrZero(message = "Invalid Id: must be greater than or equal to 0")
    @Schema(description = "Unique key of Order")
    private Long orderId;
    private int userId;
    private Timestamp createdAt;

    @Size(min = 2, max = 90, message = "Invalid name: must be of 2 - 90 characters")
    @Schema(description = "Name of deliveryAddress", example = "new Address")
    private String deliveryAddress;

    @Schema(description = "Number of Phone", example = "123454321")
    private int contactPhone;
    private String deliveryMethod;
    private OrdersEnum status;
    private Timestamp updatedAt;

    public OrdersDto() {
    }

    public OrdersDto(Long orderID, int userID, Timestamp createdAt, String deliveryAddress,
                     int contactPhone, String deliveryMethod, OrdersEnum status, Timestamp updatedAt) {
        this.orderId = orderID;
        this.userId = userID;
        this.createdAt = createdAt;
        this.deliveryAddress = deliveryAddress;
        this.contactPhone = contactPhone;
        this.deliveryMethod = deliveryMethod;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    public Long getOrderID() {
        return orderId;
    }

    public void setOrderID(Long orderID) {
        this.orderId = orderID;
    }

    public int getUserID() {
        return userId;
    }

    public void setUserID(int userID) {
        this.userId = userID;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(int contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public OrdersEnum getStatus() {
        return status;
    }

    public void setStatus(OrdersEnum status) {
        this.status = status;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDto orders = (OrdersDto) o;
        return orderId == orders.orderId && userId == orders.userId && contactPhone == orders.contactPhone && Objects.equals(createdAt, orders.createdAt) && Objects.equals(deliveryAddress, orders.deliveryAddress) && Objects.equals(deliveryMethod, orders.deliveryMethod) && Objects.equals(status, orders.status) && Objects.equals(updatedAt, orders.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, createdAt, deliveryAddress, contactPhone, deliveryMethod, status, updatedAt);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderId +
                ", userID=" + userId +
                ", createdAt=" + createdAt +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", contactPhone=" + contactPhone +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", status=" + status +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
