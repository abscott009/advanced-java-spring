package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import platform.codingnomads.co.corespring.examples.valueannotation.Nomad;
import platform.codingnomads.co.corespring.examples.valueannotation.ValueAnnotationDemo;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProfileAnnotationDemo {
    public static void main(String[] args) {

//        final ConfigurableApplicationContext ctx = SpringApplication.run(ProfileAnnotationDemo.class);
//        final ProfileLBD profileLBD = ctx.getBean(ProfileLBD.class);
//        final String framework = profileLBD.deployOut();
//        System.out.println(framework);

        final ConfigurableApplicationContext ctx2 = SpringApplication.run(ProfileAnnotationDemo.class);
        final SpringDeveloper springDeveloper = ctx2.getBean(SpringDeveloper.class);
        final String jdk = springDeveloper.testOut();
        System.out.println(jdk);
    }
}
