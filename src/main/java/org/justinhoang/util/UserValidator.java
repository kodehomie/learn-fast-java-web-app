package org.justinhoang.util;

import org.justinhoang.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator
{

    @Override
    public boolean supports(final Class clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object obj, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
                                                  "required.username");
    }
}
