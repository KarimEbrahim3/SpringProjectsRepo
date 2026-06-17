package com.global.hr.mapper;

import org.mapstruct.Mapper;

import com.global.hr.dto.EmployeeDto;
import com.global.hr.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
EmployeeDto mapToDto(Employee empEntity);
Employee mapToEntity(EmployeeDto EmpDto);
}
