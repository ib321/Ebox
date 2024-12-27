

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Owner;

public class Main {

	public static void main(String[] args) throws IOException {
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the name,password and mobile number of the user");
		String name=br.readLine();
		String password=br.readLine();
		String mobile=br.readLine();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Owner owner=(Owner)context.getBean("owner",Owner.class);
		owner.setDetails(name, password, mobile);
		owner.display();
	}

}
