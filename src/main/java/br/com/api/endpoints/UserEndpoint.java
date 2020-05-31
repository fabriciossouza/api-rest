package br.com.api.endpoints;

import br.com.api.endpoints.validator.UserValidator;
import br.com.api.entity.User;
import br.com.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rs/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserEndpoint {

    @Autowired
    private UserService service;
    @Autowired
    private UserValidator validator;

    @GetMapping
    public List<User> findAll(){
        return service.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user){
        validator.validate(user);
        return service.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public User delete(@PathVariable Long id){
        return service.delete(id);
    }
}
