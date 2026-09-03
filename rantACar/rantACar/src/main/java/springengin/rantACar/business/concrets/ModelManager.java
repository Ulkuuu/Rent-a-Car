package springengin.rantACar.business.concrets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springengin.rantACar.business.abstact.ModelServices;
import springengin.rantACar.business.requests.CreateModelRequest;
import springengin.rantACar.business.requests.UpdateModelRequest;
import springengin.rantACar.business.responses.GetAllModelresponse;
import springengin.rantACar.business.responses.GetByIdModelResponse;
import springengin.rantACar.core.utilities.mappers.ModelMappersServices;
import springengin.rantACar.dataAccess.abstaracts.ModelRepo;
import springengin.rantACar.entites.concretes.Model;
import springengin.rantACar.webApi.controllers.UpdatemodelRequest;

@Service
@AllArgsConstructor
public class ModelManager implements ModelServices {

    private final ModelRepo modelrepo;
    private final ModelMappersServices modelMappersServices;

    @Override
    public List<GetAllModelresponse> getAll() {
        List<ch.qos.logback.core.model.Model> models = this.modelrepo.findAll();

        List<GetAllModelresponse> modelsResponse = models.stream()
                .map(model -> this.modelMappersServices.forResponse()
                        .map(model, GetAllModelresponse.class))
                .collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public springengin.rantACar.business.abstact.GetByIdModelResponse getById(int id) {
        Model model = this.modelrepo.findById(id).orElseThrow();

        GetByIdModelResponse response = this.modelMappersServices.forResponse()
                .map(model, GetByIdModelResponse.class);

        return response;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMappersServices.forRequest()
                .map(createModelRequest, Model.class);

        this.modelrepo.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMappersServices.forRequest()
                .map(updateModelRequest, Model.class);

        this.modelrepo.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelrepo.deleteById(id);
    }

    @Override
    public void update(UpdatemodelRequest updateModelRequest) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}