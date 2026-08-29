package springengin.rantACar.business.abstact;

import java.util.List;

import springengin.rantACar.business.requests.CreateBrandRequest;
import springengin.rantACar.business.requests.UpdateBrandRequest;
import springengin.rantACar.business.responses.GetAllBrandRespons;
import springengin.rantACar.business.responses.GetByIdresponse;
import springengin.rantACar.entites.concretes.Brand;

public interface BrandServices {
    List<GetAllBrandRespons>getAll();

    GetByIdresponse getById(int id);

    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id );
}
