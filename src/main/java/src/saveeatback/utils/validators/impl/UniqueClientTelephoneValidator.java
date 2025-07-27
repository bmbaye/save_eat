package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.datas.repositories.ClientRepository;
import src.saveeatback.utils.validators.UniqueClientTelephone;

public class UniqueClientTelephoneValidator implements ConstraintValidator<UniqueClientTelephone, String> {
    private final ClientRepository clientRepository;

    UniqueClientTelephoneValidator(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public void initialize(UniqueClientTelephone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        var client = this.clientRepository.findByTelephone(value);
        return client.isEmpty();
    }
}
