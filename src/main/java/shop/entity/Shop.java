package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop")
@Entity(name = "Shop")
public class Shop {
    @Id
    @OneToMany(mappedBy = "shop")
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
    @JoinColumn(name = "shop_owner", referencedColumnName = "id")
    private User shopOwner;
}
