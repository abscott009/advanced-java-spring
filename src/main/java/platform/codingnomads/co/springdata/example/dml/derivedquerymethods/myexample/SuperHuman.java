package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SuperHuman {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String codeName;

    @ManyToOne
    @JoinColumn(name = "super_powers_id")
    private SuperPower superPower;

    private Integer age;
    private Boolean active;
}
