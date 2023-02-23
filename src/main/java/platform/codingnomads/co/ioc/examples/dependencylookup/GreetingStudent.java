package platform.codingnomads.co.ioc.examples.dependencylookup;

public class GreetingStudent implements GreetingProvider{

    @Override
    public String getGreeting() {
        return "Top'o the mornin' to ya!";
    }
}
