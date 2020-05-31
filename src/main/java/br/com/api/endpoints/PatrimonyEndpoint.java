package br.com.api.endpoints;

import br.com.api.endpoints.validator.PatrimonyValidator;
import br.com.api.entity.Patrimony;
import br.com.api.services.PatrimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/rs/patrimonies", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatrimonyEndpoint {

    @Autowired
    private PatrimonyService service;
    @Autowired
    private PatrimonyValidator validator;

    @GetMapping
    public List<Patrimony> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Patrimony findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Patrimony save(@RequestBody Patrimony patrimony){
        validator.validate(patrimony);
        return service.save(patrimony);
    }

    @PutMapping(value = "/{id}")
    public Patrimony update(@PathVariable Long id, @RequestBody Patrimony patrimony){
        patrimony.setId(id);
        return service.update(patrimony);
    }

    @DeleteMapping(value = "/{id}")
    public Patrimony delete(@PathVariable Long id){
        return service.delete(id);
    }
}
