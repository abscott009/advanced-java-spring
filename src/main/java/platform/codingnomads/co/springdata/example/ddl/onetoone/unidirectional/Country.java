package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "country")
@NoArgsConstructor
@Getter
@Setter

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String country;

    @OneToOne
    Driver driver;

}
