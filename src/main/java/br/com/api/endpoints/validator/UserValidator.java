package br.com.api.endpoints.validator;

import br.com.api.entity.User;
import br.com.api.infrastructure.exceptions.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserValidator implements Validator<User> {

    @Override
    public void validate(User user){

        if(StringUtils.isEmpty(user.getName())){
            throw new ValidationException("name is mandatory");
        }

        if(StringUtils.isEmpty(user.getEmail())){
            throw new ValidationException("email is mandatory");
        }

        if(StringUtils.isEmpty(user.getPassword())){
            throw new ValidationException("password is mandatory");
        }
    }
}
