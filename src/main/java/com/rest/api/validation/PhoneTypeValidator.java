package com.rest.api.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.rest.api.constraint.PhoneType;


public class PhoneTypeValidator implements ConstraintValidator<PhoneType, String>{

	private final List<String> phoneTypes = Arrays.asList("home", "work", "mobile");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return phoneTypes.contains(value);
	}
}
