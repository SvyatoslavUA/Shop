package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.EmployeeRole;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @OneToMany(mappedBy = "")
    @OneToOne(mappedBy = "shopOwner")
    private Long id;

    private String name;
    private String surname;
    private String password;

    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;
}
