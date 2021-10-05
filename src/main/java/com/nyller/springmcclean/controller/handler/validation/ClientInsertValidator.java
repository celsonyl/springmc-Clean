package com.nyller.springmcclean.controller.handler.validation;

import com.nyller.springmcclean.controller.handler.model.FieldMessage;
import com.nyller.springmcclean.controller.model.ClientRequest;
import com.nyller.springmcclean.gateway.mysql.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientRequest> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void initialize(ClientInsert constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClientRequest clientRequest, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> list = new ArrayList<>();

        var client = clientRepository.findByEmail(clientRequest.getEmail());
        if (client != null) {
            list.add(new FieldMessage("email", "Email já existente"));
        }

        for (FieldMessage field : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(field.getMessage()).addPropertyNode(field.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}