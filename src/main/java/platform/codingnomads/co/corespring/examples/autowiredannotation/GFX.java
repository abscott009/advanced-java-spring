package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("gfx")
@ToString
public class GFX implements VideoCard {
}
