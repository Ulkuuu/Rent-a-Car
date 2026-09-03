package springengin.rantACar.dataAccess.abstaracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springengin.rantACar.entites.concretes.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    boolean existsByPlate(String plate);

}