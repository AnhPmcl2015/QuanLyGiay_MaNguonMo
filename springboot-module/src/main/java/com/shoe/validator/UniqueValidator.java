package com.shoe.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    @Autowired
    private ApplicationContext applicationContext;
    private ServiceValidator service;
    private String fieldName;
    private String tableName;
    @Override
    public void initialize(Unique constraintAnnotation) {
        Class<? extends ServiceValidator> clazz = constraintAnnotation.service();
        this.fieldName=constraintAnnotation.fieldName();
        this.tableName = constraintAnnotation.tableName();
        String serviceQualifier = constraintAnnotation.serviceQualifier();
        if (!serviceQualifier.equals("")) {
            this.service = this.applicationContext.getBean(serviceQualifier, clazz);
        } else {
            this.service = this.applicationContext.getBean(clazz);
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return this.service.isUnique(value,fieldName,tableName);
    }
}
