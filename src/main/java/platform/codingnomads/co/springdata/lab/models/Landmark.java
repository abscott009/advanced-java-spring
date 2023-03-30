package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "landmark")
@Builder
@ToString
public class Landmark implements Serializable {

    private static final long serialVersionUID = -2624055642258734917L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Area area;

    @ManyToMany
    @JoinTable(
            name = "landmark_route", joinColumns = @JoinColumn(name = "landmark_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> routes;

    public Landmark(String type, String name, Area area) {
        this.type = type;
        this.name = name;
        this.area = area;
        area.addLandmark(this);

    }

    public Landmark(String type, String name, Route route) {
        this.type = type;
        this.name = name;
        this.routes = List.of(route);
    }

    public void addRoutes(List<Route> routes) {
        if (routes != null) {
            routes.forEach(r -> r.addLandmark(this));
        } else {
            routes = new ArrayList<>();
        }
        if (this.routes == null) {
            this.routes = routes;
        } else {
            this.routes.addAll(routes);
        }
    }



}
