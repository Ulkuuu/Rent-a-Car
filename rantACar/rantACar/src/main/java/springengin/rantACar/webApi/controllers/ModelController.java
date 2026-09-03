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

import springengin.rantACar.business.abstact.ModelServices;
import springengin.rantACar.business.requests.CreateModelRequest;
import springengin.rantACar.business.requests.UpdateModelRequest;
import springengin.rantACar.business.responses.GetAllModelresponse;
import springengin.rantACar.business.responses.GetByIdModelResponse;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final ModelServices modelServices;

    @Autowired
    public ModelController(ModelServices modelServices) {
        this.modelServices = modelServices;
    }

    @GetMapping
    public List<GetAllModelresponse> getAll() {
        return this.modelServices.getAll();
    }

    @GetMapping("/{id}")
    public springengin.rantACar.business.abstact.GetByIdModelResponse getById(@PathVariable int id) {
        return this.modelServices.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest) {
        this.modelServices.add(createModelRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest) {
        this.modelServices.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.modelServices.delete(id);
    }
}