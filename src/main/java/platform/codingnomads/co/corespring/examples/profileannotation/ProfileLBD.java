package platform.codingnomads.co.corespring.examples.profileannotation;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class ProfileLBD {
    @Value("${nomad.framework}")
    private String framework;

    public String deployOut() {

        return "ProfileLBD pulling framework value from application-deploy.properties: " + framework;
    }
}
