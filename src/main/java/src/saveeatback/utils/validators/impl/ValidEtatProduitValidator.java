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
        if(etat == null){
            return false;
        }
        return etat.equalsIgnoreCase("disponible") || etat.equalsIgnoreCase("en_rupture") || etat.equalsIgnoreCase("archive");
    }
}
