package springengin.rantACar.business.concrets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springengin.rantACar.business.abstact.CarServices;
import springengin.rantACar.business.requests.CreateCarRequest;
import springengin.rantACar.business.responses.GetAllCarsResponse;
import springengin.rantACar.business.rules.CarRules;
import springengin.rantACar.core.utilities.mappers.ModelMappersServices;
import springengin.rantACar.dataAccess.abstaracts.CarRepository;
import springengin.rantACar.entites.concretes.Car;

@Service
@AllArgsConstructor
public class CarManager implements CarServices {

    private final CarRepository carRepository;
    private final ModelMappersServices modelMappersServices;
    private final CarRules carRules;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = this.carRepository.findAll();

        List<GetAllCarsResponse> carsResponse = cars.stream()
                .map(car -> this.modelMappersServices.forResponse()
                        .map(car, GetAllCarsResponse.class))
                .collect(Collectors.toList());

        return carsResponse;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        // 1. İş Kuralı: Aynı plaka veritabanında var mı?
        this.carRules.checkIfPlateExists(createCarRequest.getPlate());

        // 2. DTO'yu Entity nesnesine dönüştür
        Car car = this.modelMappersServices.forRequest()
                .map(createCarRequest, Car.class);

        // 3. Veritabanına kaydet
        this.carRepository.save(car);
    }
}