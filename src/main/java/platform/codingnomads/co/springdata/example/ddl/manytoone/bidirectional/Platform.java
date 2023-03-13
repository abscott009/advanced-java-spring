package platform.codingnomads.co.springdata.example.ddl.manytoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String website;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "platform")
    private Set<Post> posts;
}

