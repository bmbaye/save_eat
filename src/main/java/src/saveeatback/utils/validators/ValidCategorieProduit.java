package src.saveeatback.utils.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.utils.validators.impl.ValidCategorieProduitValidator;
import src.saveeatback.utils.validators.impl.ValidTypeLivraisonValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Document
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCategorieProduitValidator.class)
public @interface ValidCategorieProduit {
    String message() default "La categorie est invalide !!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
