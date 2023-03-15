package shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.Status;

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

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "total_amount")
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderedProductWithAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private User courier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private User customer;
}
