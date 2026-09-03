package springengin.rantACar.business.concrets;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springengin.rantACar.business.abstact.BrandServices;
import springengin.rantACar.business.requests.CreateBrandRequest;
import springengin.rantACar.business.requests.UpdateBrandRequest;
import springengin.rantACar.business.responses.GetAllBrandRespons;
import springengin.rantACar.business.responses.GetByIdresponse;
import springengin.rantACar.business.rules.BrandRules;
import springengin.rantACar.core.utilities.exceptions.BusinessException;
import springengin.rantACar.core.utilities.mappers.ModelMappersServices;
import springengin.rantACar.dataAccess.abstaracts.Brandrepository;
import springengin.rantACar.entites.concretes.Brand;
@Service
public class BrandManager implements BrandServices{
    private Brandrepository brandrepository;
    private ModelMappersServices modelMappersServices;
    private BrandRules brandRules;
    



   @Autowired
public BrandManager(Brandrepository brandrepository, ModelMappersServices modelMappersServices, BrandRules brandRules) {
    this.brandrepository = brandrepository;
    this.modelMappersServices = modelMappersServices; 
    this.brandRules = brandRules;
}




    @Override
    public List<GetAllBrandRespons> getAll() {
       //iş kuralları

      List<Brand> brands= brandrepository.findAll();
     
        List<GetAllBrandRespons> brandRespons1=(List<GetAllBrandRespons>) brands.stream()
    .map(brand->this.modelMappersServices.forResponse()
    .map(brand,GetAllBrandRespons.class )).collect(Collectors.toList());

       return brandRespons1;
    }



//Kullanıcının dışarıdan gönderdiği isteği (Request) alıp, veritabanı modeline (Entity) çevirdik ve veritabanına bastık!
    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand=this.modelMappersServices.forRequest().map(createBrandRequest, Brand.class);

        this.brandrepository.save(brand);
        
    }




    @Override
    public GetByIdresponse getById(int id) {
        Brand brand=this.brandrepository.findById(id).orElseThrow();
        GetByIdresponse response=this.modelMappersServices.forResponse().map(brand, GetByIdresponse.class);
        return response;

    }




    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
         Brand brand=this.modelMappersServices.forRequest().map(updateBrandRequest, Brand.class);
         this.brandrepository.save(brand);
    }




    @Override
    public void delete(int id) {
        this.brandrepository.deleteById(id);
        
    }

}
