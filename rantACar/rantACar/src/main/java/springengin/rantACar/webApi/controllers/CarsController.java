package springengin.rantACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import springengin.rantACar.business.abstact.CarServices;
import springengin.rantACar.business.requests.CreateCarRequest;
import springengin.rantACar.business.responses.GetAllCarsResponse;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    private final CarServices carServices;

    @Autowired
    public CarsController(CarServices carServices) {
        this.carServices = carServices;
    }

    @GetMapping
    public List<GetAllCarsResponse> getAll() {
        return this.carServices.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateCarRequest createCarRequest) {
        this.carServices.add(createCarRequest);
    }
}