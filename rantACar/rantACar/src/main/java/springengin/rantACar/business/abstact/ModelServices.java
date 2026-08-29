package springengin.rantACar.business.abstact;

import java.util.List;

import springengin.rantACar.business.requests.CreateBrandRequest;
import springengin.rantACar.business.requests.CreateModelRequest;
import springengin.rantACar.business.requests.UpdateBrandRequest;
import springengin.rantACar.business.responses.GetAllModelresponse;
import springengin.rantACar.business.responses.GetByIdresponse;

public interface ModelServices {
 List<GetAllModelresponse>getAll();
  

    void add(CreateModelRequest createBCreateModelRequest);
    
}

