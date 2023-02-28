package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String city;
    private String state;

    public Location(String city, String state) {
        this.city = city;
        this.state = state;
    }
}