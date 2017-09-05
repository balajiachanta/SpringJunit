package com.bala;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bala.db.DBOperations;
import com.bala.db.model.User;

@RestController
public class RestCentralService {

	@Autowired
	DBOperations dBOperations;
	
	@Autowired
	ApplicationContext applicationContext;


	@RequestMapping(value="/greet", produces={"application/json"},  method = RequestMethod.GET)
	public ResponseBean readMessage(){
		System.out.println("test");

		ResponseBean r = new ResponseBean();
		r.setName("hello balU");
		User user = new User();
		//user.setId(1);
		user.setName("test");
		user.setEmail("balu");
		dBOperations.persist(user);
				
		User u = dBOperations.getByKey(1);
		r.setName(u.getName());
		return r;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("heello test");
		Arrays.asList(applicationContext.getBeanDefinitionNames()).forEach(System.out::println );
		
	}
	
	
}
