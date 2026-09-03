package springengin.rantACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import springengin.rantACar.business.abstact.BrandServices;
import springengin.rantACar.business.requests.CreateBrandRequest;
import springengin.rantACar.business.requests.UpdateBrandRequest;
import springengin.rantACar.business.responses.GetAllBrandRespons;
import springengin.rantACar.business.responses.GetByIdresponse;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private final BrandServices brandServices;

    @Autowired
    public BrandsController(BrandServices brandServices) {
        this.brandServices = brandServices;
    }

    // 1. Tüm markaları listeleme
    @GetMapping
    public List<GetAllBrandRespons> getAll() {
        return this.brandServices.getAll();
    }

    // 2. ID'ye göre tekil marka getirme (/api/brands/1)
    @GetMapping("/{id}")
    public GetByIdresponse getById(@PathVariable int id) {
        return this.brandServices.getById(id);
    }

    // 3. Yeni marka ekleme
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandServices.add(createBrandRequest);
    }

    // 4. Marka güncelleme
    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandServices.update(updateBrandRequest);
    }

    // 5. Marka silme (/api/brands/1)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandServices.delete(id);
    }
}
//@RequestBody: İstek gövdesindeki (Body) JSON verisini Java nesnesine (CreateBrandRequest, UpdateBrandRequest) dönüştürür.

//@PathVariable: URL yolundaki değişkeni (örneğin /api/brands/3 adresindeki 3 değerini) okuyup metottaki int id parametresine aktarır.

///@ResponseStatus(code = HttpStatus.CREATED): Yeni bir kayıt başarıyla veritabanına eklendiğinde standart HTTP 201 Created durum kodunu istemciye döner.