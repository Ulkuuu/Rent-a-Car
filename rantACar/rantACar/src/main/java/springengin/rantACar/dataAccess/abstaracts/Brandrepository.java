package springengin.rantACar.dataAccess.abstaracts;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springengin.rantACar.entites.concretes.Brand;
@Repository//bu sınıf bir dataaccess nesnesidir
public interface Brandrepository extends JpaRepository<Brand,Integer>{
  
    
}
