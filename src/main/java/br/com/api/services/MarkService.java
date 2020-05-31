package br.com.api.services;

import br.com.api.entity.Mark;
import br.com.api.entity.Patrimony;
import br.com.api.infrastructure.exceptions.BusinessException;
import br.com.api.infrastructure.exceptions.EntityNotFoundException;
import br.com.api.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {

    @Autowired
    private MarkRepository repository;


    public Mark findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Mark Not Found!"));
    }

    public Mark save(Mark mark){
        Mark markFound = repository.findByName(mark.getName());
        if(markFound != null){
            throw new BusinessException("Mark " + mark.getName() + " already existing!");
        }
        return repository.save(mark);
    }

    public Mark update(Mark mark){
        if(repository.existsById(mark.getId())) {
            return repository.save(mark);
        }
        throw new EntityNotFoundException("Mark Not Found!");
    }

    public Mark delete(Long id){
        Mark mark = findById(id);
        repository.delete(mark);
        return mark;
    }

    public List<Mark> findAll(){
        return repository.findAll();
    }
}
