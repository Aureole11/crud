package com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crud.model.Student;

public interface Repository extends JpaRepository<Student, Integer>{

}
