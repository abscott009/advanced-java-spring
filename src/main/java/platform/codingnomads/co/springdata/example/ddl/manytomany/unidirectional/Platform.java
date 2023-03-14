package platform.codingnomads.co.springdata.example.ddl.manytomany.unidirectional;
import lombok.*;


import javax.persistence.*;
import java.util.Date;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String website;

    @Column(nullable = false)
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "site_id")
    private Set<Post> posts;

}
