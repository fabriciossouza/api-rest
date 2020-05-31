package br.com.api.services;

import br.com.api.entity.Mark;
import br.com.api.entity.Patrimony;
import br.com.api.infrastructure.exceptions.BusinessException;
import br.com.api.infrastructure.exceptions.EntityNotFoundException;
import br.com.api.repository.MarkRepository;
import br.com.api.repository.PatrimonyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PatrimonyService {

    @Autowired
    private PatrimonyRepository repository;

    @Autowired
    private MarkService markService;


    public Patrimony findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patrimony Not Found!"));
    }

    public Patrimony save(Patrimony patrimony){
        patrimony.setMark(markService.findById(patrimony.getMark().getId()));
        patrimony.setNumTumble(new Random().nextLong());
        return repository.save(patrimony);
    }

    public Patrimony update(Patrimony patrimonyRequest){
        Patrimony patrimony = findById(patrimonyRequest.getId());
        if(patrimonyRequest.getNumTumble() != null){
            throw new BusinessException("Changes to the numTumble field are not allowed!");
        }
        BeanUtils.copyProperties(patrimonyRequest, patrimony);
        return repository.save(patrimonyRequest);
    }

    public Patrimony delete(Long id){
        Patrimony patrimony = findById(id);
        repository.delete(patrimony);
        return patrimony;
    }

    public List<Patrimony> findAllPatrimoniesByMark(Long id) {
        return repository.findAllPatrimoniesByMarkId(id);
    }

    public List<Patrimony> findAll(){
        return repository.findAll();
    }
}
