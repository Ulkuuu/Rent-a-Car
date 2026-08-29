package springengin.rantACar.business.concrets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.model.Model;
import lombok.AllArgsConstructor;
import springengin.rantACar.business.abstact.ModelServices;
import springengin.rantACar.business.requests.CreateModelRequest;
import springengin.rantACar.business.responses.GetAllBrandRespons;
import springengin.rantACar.business.responses.GetAllModelresponse;
import springengin.rantACar.core.utilities.mappers.ModelMappersServices;
import springengin.rantACar.dataAccess.abstaracts.ModelRepo;
import springengin.rantACar.entites.concretes.Brand;
@Service
@AllArgsConstructor

public class ModelManager implements ModelServices {
private ModelRepo modelrepo;
private ModelMappersServices modelMappersServices;

 @Override
    public List<GetAllModelresponse> getAll() {
       //iş kuralları

      List<Model> models= modelrepo.findAll();
     
     
      List<Object> modelsResponses = models.stream()
    .map(model -> this.modelMappersServices.forResponse().map(model, GetAllModelresponse.class))
    .collect(Collectors.toList());
      return null;
    }

 @Override

public void add(CreateModelRequest createModelRequest) {
    Model model = this.modelMappersServices.forRequest().map(createModelRequest, Model.class);
    
    this.modelrepo.save(model);
}
   

 }
   

