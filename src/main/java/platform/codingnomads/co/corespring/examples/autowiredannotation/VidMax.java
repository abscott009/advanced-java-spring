package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("vidmax")
@ToString
public class VidMax implements VideoCard {
}
