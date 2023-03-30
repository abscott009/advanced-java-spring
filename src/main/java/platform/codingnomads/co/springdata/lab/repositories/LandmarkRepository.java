package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Area;

public interface LandmarkRepository extends JpaRepository<Area,Long> {

    Iterable<Area> saveAll();

    LandmarkRepository findByCode(String code);


}
