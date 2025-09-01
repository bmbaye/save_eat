package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.utils.validators.ValidTypePaiement;

public class ValidTypePaiementValidator implements ConstraintValidator<ValidTypePaiement, String> {
    @Override
    public void initialize(ValidTypePaiement constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        return value.equalsIgnoreCase("cash")
                || value.equalsIgnoreCase("wave")
                || value.equalsIgnoreCase("orange_money");
    }
}
