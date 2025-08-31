package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.utils.validators.ValidQuantity;

public class ValidQuantityValidator implements ConstraintValidator<ValidQuantity, Integer> {
    @Override
    public void initialize(ValidQuantity constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer qte, ConstraintValidatorContext constraintValidatorContext) {
        return qte >0;
    }
}
