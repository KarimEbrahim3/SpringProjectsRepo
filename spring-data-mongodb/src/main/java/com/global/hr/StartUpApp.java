package com.global.hr;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.hr.entity.Employee;
import com.global.hr.repo.EmployeeRepo;

@Component
public class StartUpApp implements CommandLineRunner{

	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("staaaaaaaaaaaart");
//		Employee emp1 = new Employee();
//		emp1.setName("Kareem");
//		emp1.setEmail("Kareem@gmail.com");
//		emp1.setPhone("123456789");
//		
//		Employee emp2 = new Employee();
//		emp2.setName("Eslam");
//		emp2.setEmail("Eslam@gmail.com");
//		emp2.setPhone("987654321");
//		
//		Employee emp3 = new Employee();
//		emp3.setName("Ali");
//		emp3.setEmail("Ali@gmail.com");
//		emp3.setPhone("56565656");
//		
//		empRepo.insert(Arrays.asList(emp1 , emp2 , emp3));
		
		
	}

}
