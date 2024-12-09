package de.telran.onlineshop.entity;

import de.telran.onlineshop.dto.OrdersEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

//    @Column(name = "UserID")
//    private int userId;

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

    @OneToMany(mappedBy = "orders")
    private Set<OrderItemsEntity> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "UserID")
    private UsersEntity users;

    public OrdersEntity(Object o, int i, Timestamp timestamp, String bananaStreet, int i1,
                        String perCar, OrdersEnum ordersEnum, Timestamp timestamp1) {
    }

    public int getUserId() {
        return getUserId();
    }
}
