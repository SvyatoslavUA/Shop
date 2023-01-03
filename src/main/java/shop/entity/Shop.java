package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private Long id;
    private String shopName;
    private String address;
    private double workingHours;
    private String workingDays;
}
