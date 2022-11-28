package com.crud.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.crud.advice.StudentNotFoundException;
import com.crud.crud.model.Student;
import com.crud.crud.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private Repository repo;
	
	public List<Student> getAllStudent(){
		List<Student> stu = repo.findAll();
		if(((List<Student>) stu).isEmpty()) {
			throw new StudentNotFoundException();
		}
		return stu;
		//return repo.findAll();
	}
	
	public Optional<Student> getStu(int id) {
		return repo.findById(id);
	}
	
	public Student addStu(Student stu) {
		return repo.save(stu);
	}
	
	public Student update(Student stu) {
		return repo.save(stu);
	}
	
	public void deleteStudent(int id) {
		repo.deleteById(id);
	}

}
