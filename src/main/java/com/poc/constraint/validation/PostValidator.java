package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.PostDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PostDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostDTO postDTO = (PostDTO) target;
        if (StringUtils.isEmpty(postDTO.getTitle())) {
            errors.rejectValue("title", "title.value.empty", ErrorsEnum.ERR_MCS_POST_TITLE_EMPTY.getErrorMessage());
        }
    }
}
