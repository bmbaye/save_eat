package src.saveeatback.utils.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.utils.validators.impl.UniqueClientTelephoneValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Document
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueClientTelephoneValidator.class)
public @interface UniqueClientTelephone {
    String message() default "Ce telephone appartient deja a un client";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
