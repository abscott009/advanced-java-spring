package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Landmark;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.LandmarkRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;
    private final LandmarkRepository landmarkRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }



    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().size() == 0) {

            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("A").build(),
                            Area.builder().code("B").build(),
                            Area.builder().code("C").build(),
                            Area.builder().code("D").build(),
                            Area.builder().code("W").build(),
                            Area.builder().code("X").build(),
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
                    Route.builder().origin(areaRepository.findByCode("A"))
                            .destination((areaRepository.findByCode("Z"))).build(),
                    Route.builder().origin(areaRepository.findByCode("B"))
                            .destination((areaRepository.findByCode("Y"))).build(),
                    Route.builder().origin(areaRepository.findByCode("C"))
                            .destination((areaRepository.findByCode("X"))).build(),
                    Route.builder().origin(areaRepository.findByCode("D"))
                            .destination((areaRepository.findByCode("W"))).build(),
                    Route.builder().origin(areaRepository.findByCode("W"))
                            .destination((areaRepository.findByCode("B"))).build(),
                    Route.builder().origin(areaRepository.findByCode("X"))
                            .destination((areaRepository.findByCode("A"))).build(),
                    Route.builder().origin(areaRepository.findByCode("Y"))
                            .destination((areaRepository.findByCode("A"))).build(),
                    Route.builder().origin(areaRepository.findByCode("Z"))
                            .destination((areaRepository.findByCode("D"))).build()
            );

Landmark myLandmark = Landmark.builder().build();
List<Landmark> landmarkList = new ArrayList<>();
landmarkList.add(myLandmark);

            if (landmarkRepository.findAll().size() == 0) {

                final List<Landmark> landmarks = landmarkRepository.saveAll(landmarkList);
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
