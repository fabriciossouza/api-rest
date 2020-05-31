package br.com.api.services;

import br.com.api.entity.Mark;
import br.com.api.entity.User;
import br.com.api.infrastructure.exceptions.BusinessException;
import br.com.api.infrastructure.exceptions.EntityNotFoundException;
import br.com.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findByName(String userName){
        return repository.findByName(userName);
    }

    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User Not Found!"));
    }

    public User save(User user){
        User emailFound = repository.findByEmail(user.getEmail());
        if(emailFound != null){
            throw new BusinessException("Email " + user.getEmail() + " already existing!");
        }
        return repository.save(user);
    }

    public User delete(Long id){
        User user = findById(id);
        repository.delete(user);
        return user;
    }

    public List<User> findAll(){
        return repository.findAll();
    }
}
