package shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import shop.entity.enumeration.UserRole;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @Column(name = "email")
    private String email;


    @OneToOne(mappedBy = "shopOwner")
    private Shop shop;

    @OneToMany(mappedBy = "courier", fetch = FetchType.LAZY)
    private List<Order> delivered;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> received;
}
