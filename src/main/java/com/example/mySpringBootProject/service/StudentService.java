package com.example.mySpringBootProject.service;

import org.springframework.stereotype.Component;

import com.example.mySpringBootProject.bean.Student;
import com.example.mySpringBootProject.exception.StudentNotFoundException;

@Component
public class StudentService {

	public String getAllStudents() {
		return "Returning all the students' names.";
	}

	public String getStudentById(int id) {
		if (id < 0) {
			throw new StudentNotFoundException();
		}
		return "Returning the student with ID: " + id;
	}

	public String addStudent(Student student) {
		return "Adding the student - " + student;
	}

	public String removeStudentt(int id) {
		return "Removing the student with ID: " + id;
	}

	public String updateStudent(Student student) {
		return "Updating the student - " + student;
	}

}
