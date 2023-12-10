package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository; 

    public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> GetStudents() {
		return studentRepository.findAll();
	}

	public void AddStudent(Student student){
		Optional<Student> studentOptional = studentRepository.FindStudentByEmail(student.getEmail());
		
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}

		studentRepository.save(student);
	}
}
