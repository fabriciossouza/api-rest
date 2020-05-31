package br.com.api.endpoints;

import br.com.api.endpoints.validator.MarkValidator;
import br.com.api.entity.Mark;
import br.com.api.entity.Patrimony;
import br.com.api.services.MarkService;
import br.com.api.services.PatrimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rs/marks", produces = MediaType.APPLICATION_JSON_VALUE)
public class MarkEndpoint {

    @Autowired
    private MarkService service;
    @Autowired
    private PatrimonyService patrimonyService;
    @Autowired
    private MarkValidator validator;

    @GetMapping
    public List<Mark> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mark findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping(value = "/{id}/patrimonies")
    public List<Patrimony> findAllPatrimoniesByMark(@PathVariable Long id){
        return patrimonyService.findAllPatrimoniesByMark(id);
    }

    @PostMapping
    public Mark save(@RequestBody Mark mark){
        validator.validate(mark);
        return service.save(mark);
    }

    @PutMapping(value = "/{id}")
    public Mark update(@PathVariable Long id, @RequestBody Mark mark){
        mark.setId(id);
        return service.update(mark);
    }

    @DeleteMapping(value = "/{id}")
    public Mark delete(@PathVariable Long id){
        return service.delete(id);
    }
}
