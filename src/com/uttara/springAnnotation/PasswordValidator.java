 package com.uttara.springAnnotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD })
@Retention(RUNTIME)
@Constraint (validatedBy = {IsPasswordValidator.class} )
public @interface PasswordValidator 
{
	Class<?>[] groups() default{};
	
	Class<? extends Payload> [] payload() default {};

}
