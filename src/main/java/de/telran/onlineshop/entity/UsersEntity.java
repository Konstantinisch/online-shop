package de.telran.onlineshop.entity;

import de.telran.onlineshop.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "PasswordHash")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private CartEntity cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FavoritesEntity> favorites = new HashSet<>();

    @OneToMany(mappedBy = "users" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrdersEntity> ordersEntities = new HashSet<>();

    public UsersEntity(Object o, String дуняСеменова, String mail, String number, String number1, Role role, CartEntity cart2, Object o1, Object o2) {
    }


//    @ManyToMany
//    @JoinTable(name = "UsersAddresses",
//            joinColumns = @JoinColumn(name = "UserID"),
//            inverseJoinColumns = @JoinColumn(name = "AddressID"))
//    private Set<AddressEntity> addresses =  new HashSet<>();
}