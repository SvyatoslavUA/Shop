package shop.entity;

import jakarta.persistence.*;
import lombok.*;
import shop.entity.enumeration.Material;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "guarantee")
    private double guarantee;

    @Enumerated(EnumType.STRING)
    @Column(name = "material")
    private Material material;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @OneToMany(mappedBy = "product")
    private List<ShopProduct> productsInShop;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> productsInOrder;
}
