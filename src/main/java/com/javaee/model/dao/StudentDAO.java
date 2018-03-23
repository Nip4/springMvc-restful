package com.javaee.model.dao;

import java.util.List;

import com.javaee.model.domain.Student;

public interface StudentDAO {
	public Student addStudent(Student student);
	public long deletStudent(Long id);
	public Student queryOneStudent(Long id);
	public Student changeStudent(Student student);
	public List<Student> getStudentList();
}
