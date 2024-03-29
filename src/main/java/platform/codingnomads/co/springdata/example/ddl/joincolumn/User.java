package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)

    @JoinColumns({
            @JoinColumn(name = "references_id", referencedColumnName = "id"),
            @JoinColumn(name = "ranking", referencedColumnName = "ranking"),

    })
    private Ranking ranking;
}
