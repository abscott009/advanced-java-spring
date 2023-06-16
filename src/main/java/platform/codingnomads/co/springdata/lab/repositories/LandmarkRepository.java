package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Landmark;
import platform.codingnomads.co.springdata.lab_complete.models.PointOfInterest;

import java.util.List;

public interface LandmarkRepository extends JpaRepository<Landmark,Long> {

    Iterable<Landmark> saveAll();

    LandmarkRepository findByCode(String code);

    List<Landmark> findAllByArea_code(String code);

    List<Landmark> findAllByRoute_codeContaing(String code);


}
