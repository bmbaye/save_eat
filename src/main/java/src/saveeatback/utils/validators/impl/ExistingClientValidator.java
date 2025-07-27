package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.datas.repositories.ClientRepository;
import src.saveeatback.utils.validators.ExistingClient;

public class ExistingClientValidator implements ConstraintValidator<ExistingClient, String> {
    private final ClientRepository clientRepository;

    ExistingClientValidator(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
    public void initialize(ExistingClient constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        var client = this.clientRepository.findById(value);
        return client.isPresent();
    }
}
