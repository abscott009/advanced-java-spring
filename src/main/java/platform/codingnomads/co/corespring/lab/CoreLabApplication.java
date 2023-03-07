package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.lab.complete.*;
import platform.codingnomads.co.corespring.lab.complete.Distiller;

@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                CoreLabConfig.class);

        Bourbon bourbon = ctx.getBean(Bourbon.class);

        System.out.println("Time to sit down, relax, and have a nice glass of "
                + bourbon.getLabel() + " " + bourbon.getProof() + "% bourbon.");

        String[] distillery = ctx.getBeanNamesForType(Distiller.class);

        for (String brand : distillery) {
            System.out.println("Made by " + ctx.getBean(brand, Distiller.class).getDistillerName()
                    + " in the state of " + ctx.getBean(brand, Distiller.class).getState() + ".");
        }

        System.out.println("Done for the day!");
    }
}
