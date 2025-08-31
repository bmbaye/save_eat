package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.utils.validators.ValidPrix;

public class ValidPrixValidator implements ConstraintValidator<ValidPrix, Double> {
    @Override
    public void initialize(ValidPrix constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Double prix, ConstraintValidatorContext constraintValidatorContext) {
        return prix >0.0;
    }
}
