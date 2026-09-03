package springengin.rantACar.dataAccess.abstaracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springengin.rantACar.entites.concretes.Brand;

@Repository
public interface Brandrepository extends JpaRepository<Brand, Integer> {
    
    boolean existsByName(String name);

    boolean exisexistsByName(String name);
    
}