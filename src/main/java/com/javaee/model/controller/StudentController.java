package com.javaee.model.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.model.dao.StudentDAO;
import com.javaee.model.domain.Student;

@RestController
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value="/students",method=RequestMethod.GET)
	@ResponseBody
	public List<Student> getStudentList(){
		List<Student> student = studentDAO.getStudentList();
		return student;
	}
	
	@RequestMapping(value="/students/{id}",method=RequestMethod.GET)
	public ResponseEntity<Student> queryOneStudent(@PathVariable("id") long id){
		Student queryOneStudent = studentDAO.queryOneStudent(id);
		return new ResponseEntity<Student>(queryOneStudent,HttpStatus.OK);
	}
	
	@RequestMapping (value="/students/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Long> deleteStudent(@PathVariable("id") long id){
		long deletStudent = studentDAO.deletStudent(id);
		return new ResponseEntity<Long>(deletStudent,HttpStatus.OK);
	}
	
	@RequestMapping(value="/students{id}",method=RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@PathVariable("id") long id){
		Student student = new Student(id,"rex","male");
		studentDAO.addStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@RequestMapping(value="/students/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Student> changeStudent(@PathVariable("id") long id){
		Student student = new Student(id,"leona","female");
		student = studentDAO.changeStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
