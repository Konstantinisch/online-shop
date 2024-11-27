package de.telran.onlineshop.entity;

import de.telran.onlineshop.dto.OrdersEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrdersEntity {

    @Id
    @Column(name = "OrderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "UserID")
    private int userId;

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "DeliveryAddress")
    private String deliveryAddress;

    @Column(name = "ContactPhone")
    private int contactPhone;

    @Column(name = "DeliveryMethod")
    private String deliveryMethod;

    @Column(name = "Status")
    private OrdersEnum status;

    @Column(name = "UpdateAt")
    private Timestamp updatedAt;
}
