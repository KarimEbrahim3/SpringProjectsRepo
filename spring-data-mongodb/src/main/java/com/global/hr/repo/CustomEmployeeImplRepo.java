package com.global.hr.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;
import com.mongodb.client.result.UpdateResult;

@Repository
public class CustomEmployeeImplRepo implements CustomEmployeeRepo{
	@Autowired
	private MongoTemplate mongoTemp;
	
	@Override
	public void updateEmail(String name , String email) {
      Query query = new Query(Criteria.where("name").is(name));
      Update update = new Update();
      update.set("email", email);
      
      UpdateResult result = mongoTemp.updateFirst(query, update, Employee.class);
       if(result == null) {
    	   System.out.println("No documents updated");
       }
       else {
    	   System.out.println(result.getModifiedCount() + " documents updated..");
	}
		
	}

}
