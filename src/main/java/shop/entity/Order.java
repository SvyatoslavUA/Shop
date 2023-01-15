package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.Status;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
@Entity(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User customer;

    @Column(name = "ordered_product_with_amount")
    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderedProductWithAmount;

    @Column(name = "shop_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @Column(name = "courier_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User courier;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "total_amount")
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
