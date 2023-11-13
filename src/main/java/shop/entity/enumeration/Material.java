package shop.entity.enumeration;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Material {
    WALNUT(10),
    OAK(8),
    ASH(6),
    PINE(5),
    CHIPBOARD(2);

    private double multiplier;

    public double getMultiplier() {
        return multiplier;
    }
}
