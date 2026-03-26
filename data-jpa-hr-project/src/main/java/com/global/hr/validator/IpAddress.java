package com.global.hr.validator;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { IpAddressImpl.class})
public @interface IpAddress {
	String message() default "{validation.constraints.IpAddress.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
