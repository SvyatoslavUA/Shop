package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @OneToMany(mappedBy = "shop")
    private Long id;
    private String shopName;
    private String address;
    private double workingHours;
    private String workingDays;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_owner", referencedColumnName = "id")
    private User shopOwner;
}
