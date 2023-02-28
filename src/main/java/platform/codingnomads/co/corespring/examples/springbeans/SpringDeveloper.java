package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Location location;

    public SpringDeveloper(Address address, Location location) {

        this.address = address;
        this.location = location;
    }
}
