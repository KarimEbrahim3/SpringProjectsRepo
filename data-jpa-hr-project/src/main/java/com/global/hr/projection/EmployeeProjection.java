package com.global.hr.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
Long getId();
String getName();
String getLastName();

@Value("#{target.name}"+' '+"#{target.lastName}")
String getFullName();
}
