package shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop")
@Entity(name = "Shop")
public class Shop {
    @Id
    private Long id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "address")
    private String address;

    @Column(name = "working_hours")
    private double workingHours;

    @Column(name = "working_days")
    private String workingDays;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_owner_id", referencedColumnName = "id")
    private User shopOwner;

    @OneToMany(mappedBy = "shop")
    private List<Order> order;
}
