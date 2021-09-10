package com.nyller.springmcclean.controller.handler.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ClientInsertValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ClientInsert {
    String message() default "Erro de validação";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}