package com.example.mySpringBootProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mySpringBootProject.bean.Student;
import com.example.mySpringBootProject.service.MySpringBootService;
import com.example.mySpringBootProject.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	MySpringBootService baseService;

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/message", method = RequestMethod.GET, produces = "application/text")
	public String getMessage() {
		// return new MySpringBootService().fetchMessage();
		return baseService.fetchMessage();
	}

	// Student service - REST APIs

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = "application/text")
	public String getStudent(@PathVariable("id") Integer id) {
		// return new MySpringBootService().fetchMessage();
		return studentService.getStudentById(id);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/text")
	public String getStudents() {
		// return new MySpringBootService().fetchMessage();
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST, consumes = "application/json")
	public String addStudent(@RequestBody Student student) {
		// return new MySpringBootService().fetchMessage();
		return studentService.addStudent(student);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public String removeStudent(@PathVariable("id") Integer id) {
		// return new MySpringBootService().fetchMessage();
		return studentService.removeStudentt(id);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.PATCH)
	public String updateStudent(@RequestBody Student student) {
		// return new MySpringBootService().fetchMessage();
		return studentService.updateStudent(student);
	}

}
