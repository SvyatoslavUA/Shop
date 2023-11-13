package shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop")
@Entity(name = "Shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "working_hours_start")
    private String workingHoursStart;

    @Column(name = "working_hours_end")
    private String workingHoursEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "working_days")
    private DayOfWeek workingDays;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_owner_id", referencedColumnName = "id")
    private User shopOwner;

    @OneToMany(mappedBy = "shop")
    private List<Order> order;

    @OneToMany(mappedBy = "shop")
    private List<ShopProduct> shopHasProducts;
}
