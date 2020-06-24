package com.rest.api.constraint;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import com.rest.api.validation.PhoneTypeValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneTypeValidator.class)

public @interface PhoneType {
	String message() default "Phone type must be home, work, or mobile";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
