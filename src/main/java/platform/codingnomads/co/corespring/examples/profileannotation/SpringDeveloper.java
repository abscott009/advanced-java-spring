package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
@ImportResource({"classpath*:application-test.properties"})
public class SpringDeveloper {
    @Value("${nomad.jdk}")
    private String jdk;

    public String testOut() {

        return "SpringDeveloper pulling JDK value from application-test.properties: " + jdk;
    }
}
