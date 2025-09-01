package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.utils.validators.ValidCategorieProduit;

public class ValidCategorieProduitValidator implements ConstraintValidator<ValidCategorieProduit, String> {
    @Override
    public void initialize(ValidCategorieProduit constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String categorie, ConstraintValidatorContext constraintValidatorContext) {
        if(categorie == null){
            return false;
        }
        return categorie.equalsIgnoreCase("fruit") || categorie.equalsIgnoreCase("legume");
    }
}
