package com.crud.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crud.model.Student;
import com.crud.crud.service.Service;

@RestController
public class Controller {
	@Autowired
	Service serv;

	@GetMapping("/student")
	private List<Student> getAllStudent(){
		return serv.getAllStudent();
	}
	
	@GetMapping("/student/{id}")
	private Optional<Student> get(@PathVariable("id")int id) {
		return serv.getStu(id);
	}
	
	@PostMapping("/stuadd")
	private ResponseEntity<Student> addStu(@RequestBody @Valid Student stu){
//		Logger.info("Receive request to add user");
		try {
			stu = serv.addStu(stu);
		}
		catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(stu, HttpStatus.OK);
	}
	
	@PutMapping("/updatestu")
	private Student updateStu(@RequestBody Student stu) {
		return serv.update(stu);
	}
	
	@DeleteMapping("/deletestu/{id}")
	private void deleteStu(@PathVariable("id")int id) {
		serv.deleteStudent(id);
	}
}
