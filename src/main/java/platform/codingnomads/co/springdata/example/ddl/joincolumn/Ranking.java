package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ranking")
@NoArgsConstructor
@Getter
@Setter
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ranking")
    private String rank;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)

    @JoinColumns({
            @JoinColumn(name = "references_id", referencedColumnName = "id"),
            @JoinColumn(name = "title", referencedColumnName = "title"),

    })
    private Game game;

}
