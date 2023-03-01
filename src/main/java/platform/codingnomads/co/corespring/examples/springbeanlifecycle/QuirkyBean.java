package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class QuirkyBean implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("something quirky to the console");
    }
}
