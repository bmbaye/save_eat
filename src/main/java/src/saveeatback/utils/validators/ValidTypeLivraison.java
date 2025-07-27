package src.saveeatback.utils.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.utils.validators.impl.UniqueUsernameValidator;
import src.saveeatback.utils.validators.impl.ValidTypeLivraisonValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Document
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidTypeLivraisonValidator.class)
public @interface ValidTypeLivraison {
    String message() default "Ce type de livraison n'est pas valid !!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
