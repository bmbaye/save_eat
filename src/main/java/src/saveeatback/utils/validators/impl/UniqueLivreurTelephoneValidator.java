package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.datas.repositories.LivreurRepository;
import src.saveeatback.utils.validators.UniqueLivreurTelephone;

public class UniqueLivreurTelephoneValidator implements ConstraintValidator<UniqueLivreurTelephone, String> {

    private final LivreurRepository livreurRepository;
    UniqueLivreurTelephoneValidator(LivreurRepository livreurRepository){
        this.livreurRepository = livreurRepository;
    }
    @Override
    public void initialize(UniqueLivreurTelephone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String telephone, ConstraintValidatorContext context) {
        var livreur = this.livreurRepository.findByTelephone(telephone);
        return livreur.isEmpty();
    }
}
