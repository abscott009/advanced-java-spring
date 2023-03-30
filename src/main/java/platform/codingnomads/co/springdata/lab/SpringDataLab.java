package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }



    @Override
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().size() == 0) {

            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("A").build(),
                            Area.builder().code("B").build(),
                            Area.builder().code("C").build(),
                            Area.builder().code("D").build(),
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build()
                    )
            );

        }

        Route myRoute = Route.builder().build();
        List<Route> myList = new ArrayList<>();
        myList.add(myRoute);

        if (routeRepository.findAll().size() == 0) {

            final List<Route> routes = routeRepository.saveAll(myList);
            Arrays.asList(
                    Route.builder().origin(areaRepository.findByCode("A")).destination((areaRepository.findByCode("Z"))).build(),
                    Route.builder().origin(areaRepository.findByCode("B")).destination((areaRepository.findByCode("Y"))).build(),
                    Route.builder().origin(areaRepository.findByCode("C")).destination((areaRepository.findByCode("H"))).build(),
                    Route.builder().origin(areaRepository.findByCode("D")).destination((areaRepository.findByCode("G"))).build(),
                    Route.builder().origin(areaRepository.findByCode("G")).destination((areaRepository.findByCode("B"))).build(),
                    Route.builder().origin(areaRepository.findByCode("H")).destination((areaRepository.findByCode("A"))).build(),
                    Route.builder().origin(areaRepository.findByCode("Y")).destination((areaRepository.findByCode("A"))).build(),
                    Route.builder().origin(areaRepository.findByCode("Z")).destination((areaRepository.findByCode("D"))).build()
            );

        }

    }
}
