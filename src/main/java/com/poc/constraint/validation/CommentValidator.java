package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.CommentDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CommentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CommentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CommentDTO commentDTO = (CommentDTO) target;
        if (StringUtils.isEmpty(commentDTO.getText())) {
            errors.rejectValue("text", "text.value.empty", ErrorsEnum.ERR_MCS_COMMENT_TEXT_EMPTY.getErrorMessage());
        }
    }

}
