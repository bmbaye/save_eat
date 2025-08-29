package src.saveeatback.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import src.saveeatback.utils.validators.IsValidEmail;

import java.util.regex.Pattern;

public class IsValidEmailValidator implements ConstraintValidator<IsValidEmail, String> {

    private final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    @Override
    public void initialize(IsValidEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String emailValue, ConstraintValidatorContext constraintValidatorContext) {
        if (emailValue == null) return false;
        if(emailValue.trim().isEmpty()) return false;

        return EMAIL_PATTERN.matcher(emailValue).matches();
    }
}
