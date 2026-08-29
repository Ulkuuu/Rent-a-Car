package springengin.rantACar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import springengin.rantACar.business.abstact.BrandServices;
import springengin.rantACar.business.requests.CreateBrandRequest;
import springengin.rantACar.business.requests.UpdateBrandRequest;
import springengin.rantACar.business.responses.GetAllBrandRespons;
import springengin.rantACar.business.responses.GetByIdresponse;
import springengin.rantACar.entites.concretes.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RequestMapping("/api/brands")//sınıfın internet adresi
@RestController //REST API kontrolcüsü




public class BrandsController {
    private BrandServices brandServices;


@Autowired
//Benim arka plandaki asıl işlemleri yaptırabilmem için BrandServices adındaki iş katmanına ihtiyacım var
    public BrandsController(BrandServices brandServices) {
        this.brandServices = brandServices;
    }




@GetMapping("/{id}")

    public GetByIdresponse getById(@PathVariable int id){
        return brandServices.getById(id);
}

@PostMapping()
@ResponseStatus(code=HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest){
        this.brandServices.add(createBrandRequest);
    }

@PutMapping("path/{id}")
public void update (@RequestBody UpdateBrandRequest updateBrandRequest) {
    this.brandServices.update(updateBrandRequest);
    
   
}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
this.brandServices.delete(id);




    }
}
