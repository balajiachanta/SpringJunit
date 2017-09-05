package com.bala;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

class SpringContext {
}




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContext.class)
@WebAppConfiguration
public class App {
	
	
	@Test
	public void testGetTodosAboutSpring(){
	
		assertEquals("Spring","Spring");
	}
}


