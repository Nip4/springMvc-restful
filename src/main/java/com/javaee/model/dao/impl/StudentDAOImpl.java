package com.javaee.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaee.model.dao.StudentDAO;
import com.javaee.model.domain.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO{
	
	private static List<Student> students;
	
	{
		students = new ArrayList<Student>();
		students.add(new Student(101, "Mike", "male"));
		students.add(new Student(102, "Huang", "male"));  
		students.add(new Student(103, "Mao", "female"));  
	}
	
	@Override
	public Student addStudent(Student student) {
		students.add(student);
		return student;
	}

	@Override
	public long deletStudent(Long id) {
		for (Student student : students) {
			if(student.getId() == id) {
				students.remove(student);
			}
		}
		return id;
	}

	@Override
	public Student queryOneStudent(Long id) {
		for(Student stu : students) {
			if(stu.getId() == id) {
				return stu;
			}
		}
		return null;
	}

	@Override
	public Student changeStudent(Student student) {
		for(Student stu : students) {
			if(stu.getId() == student.getId()) {
				return stu;
			}
		}
		return null;
	}

	@Override
	public List<Student> getStudentList() {
		return students;
	}

}
