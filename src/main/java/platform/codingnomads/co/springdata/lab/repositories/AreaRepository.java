package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.example.dml.introducingrepositories.crudrepository.User;
import platform.codingnomads.co.springdata.lab.models.Area;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area,Long> {

    Iterable<Area> saveAll();

    Area findByCode(String code);

}
