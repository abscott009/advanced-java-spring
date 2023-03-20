package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.Plant;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.ArrayList;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query(value = "SELECT st, p FROM SoilType st JOIN Plant p ON st.true = p.id")
    ArrayList<SoilType> findSoilTypeEagerLoadPlant();

    @Query("SELECT st FROM Plant p")
    ArrayList<Plant> getPlantsBYSoilType();

    @Query("SELECT st FROM Plants p WHERE fruitBearing = true")
    ArrayList<SoilType> findFruitBearingPlants();

    @Query("SELECT st FROM SoilType st")
    Page<SoilType> getPagedSoilType(Pageable pageable);


}
