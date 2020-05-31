package br.com.api.endpoints.validator;

import br.com.api.entity.Mark;
import br.com.api.entity.Patrimony;
import br.com.api.infrastructure.exceptions.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MarkValidator implements Validator<Mark> {

    @Override
    public void validate(Mark mark){

        if(StringUtils.isEmpty(mark.getName())){
            throw new ValidationException("name is mandatory");
        }
    }
}
