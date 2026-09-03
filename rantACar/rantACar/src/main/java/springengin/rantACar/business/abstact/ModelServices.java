package springengin.rantACar.business.abstact;

import java.util.List;
import springengin.rantACar.business.requests.CreateModelRequest;
import springengin.rantACar.business.requests.UpdateModelRequest;
import springengin.rantACar.business.responses.GetAllModelresponse;
import springengin.rantACar.webApi.controllers.UpdatemodelRequest;

public interface ModelServices {
    List<GetAllModelresponse> getAll();
    GetByIdModelResponse getById(int id);
    void add(CreateModelRequest createModelRequest);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);
    void update(UpdatemodelRequest updateModelRequest);
}