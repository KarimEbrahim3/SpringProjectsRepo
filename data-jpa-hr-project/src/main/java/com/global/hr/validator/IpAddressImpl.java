package com.global.hr.validator;

import java.net.InetAddress;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IpAddressImpl implements ConstraintValidator<IpAddress, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
        // لو null أو فاضي سيبه يعدي (حسب استخدامك)
        if (value == null || value.trim().isEmpty()) {
            return true; // أو false لو عايزه required
        }

        try {
            InetAddress.getByName(value);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

}
