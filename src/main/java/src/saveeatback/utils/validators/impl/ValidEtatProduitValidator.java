package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.utils.validators.ValidEtatProduit;

public class ValidEtatProduitValidator implements ConstraintValidator<ValidEtatProduit, String> {
    @Override
    public void initialize(ValidEtatProduit constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String etat, ConstraintValidatorContext constraintValidatorContext) {
        return etat.equalsIgnoreCase("disponibe") || etat.equalsIgnoreCase("en_rupture") || etat.equalsIgnoreCase("archive");
    }
}
