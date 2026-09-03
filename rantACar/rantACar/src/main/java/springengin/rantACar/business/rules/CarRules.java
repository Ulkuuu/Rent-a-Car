package springengin.rantACar.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springengin.rantACar.core.utilities.exceptions.BusinessException;
import springengin.rantACar.dataAccess.abstaracts.CarRepository;

@Service
@AllArgsConstructor
public class CarRules {

    private final CarRepository carRepository;

    public void checkIfPlateExists(String plate) {
        if (this.carRepository.existsByPlate(plate)) {
            throw new BusinessException("Car plate already exists");
        }
    }
}