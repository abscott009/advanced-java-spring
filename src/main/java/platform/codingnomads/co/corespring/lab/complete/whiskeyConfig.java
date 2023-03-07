package platform.codingnomads.co.corespring.lab.complete;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/distiller.xml"})
public class whiskeyConfig {

    @Bean
    public Bourbon bourbon() {
        return new Bourbon("EH Taylor Barrel Proof", 113.6);
    }
}