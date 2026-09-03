package springengin.rantACar.business.abstact;

import java.util.List;

import springengin.rantACar.business.requests.CreateCarRequest;
import springengin.rantACar.business.responses.GetAllCarsResponse;

public interface CarServices {

    List<GetAllCarsResponse> getAll();

    void add(CreateCarRequest createCarRequest);

}