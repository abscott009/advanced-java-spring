package platform.codingnomads.co.springdata.example.ddl.manytomany.unidirectional;
import lombok.*;


import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String imageId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Comment comment;
}
