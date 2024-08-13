package com.SpringBoot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SpringBoot.learn_jpa_and_hibernate.course.Course;
import com.SpringBoot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.SpringBoot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.SpringBoot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1, "Learn AWS jpa" , "in28minutes"));
		repository.save(new Course(2, "Learn Azure jpa" , "in28minutes"));
		repository.save(new Course(3, "Learn Devops jpa" , "in28minutes"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.print(repository.findAll());
		
		System.out.print(repository.findByName("Learn Azure jpa"));
		System.out.print(repository.findByName(""));
		System.out.print(repository.findByAuthor("in28minutes"));
		System.out.print(repository.findByAuthor(""));
	}

}
