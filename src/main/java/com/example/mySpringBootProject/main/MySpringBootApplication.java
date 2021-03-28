package com.example.mySpringBootProject.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mySpringBootProject.bean.Student;
import com.example.mySpringBootProject.service.MySpringBootService;
import com.example.mySpringBootProject.service.StudentService;

//@ComponentScan
@SpringBootApplication(scanBasePackages = "com.example.mySpringBootProject")
//@SpringBootTest(classes = StudentTest.class)
public class MySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
		System.out.println("hello");
	}



}
