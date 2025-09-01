package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.utils.validators.ValidTypeLivraison;

public class ValidTypeLivraisonValidator implements ConstraintValidator<ValidTypeLivraison, String> {
    @Override
    public void initialize(ValidTypeLivraison constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        return value.equalsIgnoreCase("simple") || value.equalsIgnoreCase("express");
    }
}
