package br.com.api.endpoints.validator;

import br.com.api.entity.Patrimony;
import br.com.api.infrastructure.exceptions.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PatrimonyValidator implements Validator<Patrimony> {

    @Override
    public void validate(Patrimony patrimony){
        if(StringUtils.isEmpty(patrimony.getName())){
            throw new ValidationException("name is mandatory");
        }

        if(StringUtils.isEmpty(patrimony.getMark()) || StringUtils.isEmpty(patrimony.getMark().getId())){
            throw new ValidationException("mark{id} is mandatory");
        }
    }
}
