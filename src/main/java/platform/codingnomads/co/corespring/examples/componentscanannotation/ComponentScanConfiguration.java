package platform.codingnomads.co.corespring.examples.componentscanannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import platform.codingnomads.co.corespring.examples.componentscanannotation.componentscanLBD.ComponentOne;

@Configuration
@ComponentScan(basePackages = "platform.codingnomads.co.corespring.examples.componentscanannotation.componentscanLBD")
public class ComponentScanConfiguration {

    @Bean
    public SampleBean sampleBean() {
        return new SampleBean();
    }


}
