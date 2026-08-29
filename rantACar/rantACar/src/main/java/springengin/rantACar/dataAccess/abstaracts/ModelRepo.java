package springengin.rantACar.dataAccess.abstaracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.model.Model;
import springengin.rantACar.entites.concretes.Brand;
@Repository

public interface  ModelRepo  extends JpaRepository<Model,Integer>{



}
