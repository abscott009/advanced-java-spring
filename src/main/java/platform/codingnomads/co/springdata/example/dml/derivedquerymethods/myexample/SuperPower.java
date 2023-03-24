package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SuperPower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String superPower;
}
