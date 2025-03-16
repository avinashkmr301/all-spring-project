package com.avi.cruddemo;

import com.avi.cruddemo.dao.StudentDAO;
import com.avi.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
		@Bean
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
			return runner->{
				//createStudent(studentDAO);
				createMultipleStudent(studentDAO);
				//findStudentById(studentDAO);
				//queryForStudents(studentDAO);
				//quesyForStudentByLastName(studentDAO);
				//updateStudent(studentDAO);
				//deleteStudent(studentDAO);
				//deleteAllStudent(studentDAO);
			};
		}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all Students...");
		int i = studentDAO.deleteAll();
		System.out.println(i+ " :rows deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting Student with id: "+studentId);
		// delete student
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId =3;
		System.out.println("Find student for Id: "+studentId);
		Student theStudent = studentDAO.findById(studentId);
		//set/update details
		System.out.println("Updating student");
		theStudent.setFirstName("Amit");
		//  updated the student
		studentDAO.update(theStudent);
		//display the updated Student
		System.out.println("Updated student is: "+ theStudent);
	}

	private void quesyForStudentByLastName(StudentDAO studentDAO) {
		List<Student> name = studentDAO.findByLastName("Dao");

		for (Student s: name){
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("Found all students with JPQL query");
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display a list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void findStudentById(StudentDAO studentDAO) {
		// given id
		int id = 2;
		System.out.println("Find Student for id: "+ id);
		System.out.println("finding student...");
		Student foundStudent = studentDAO.findById(id);
		System.out.println(foundStudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Created multiple obj");
		Student student1 = new Student("John","Dao","john@mail.com");
		Student student2 = new Student("Arun","Singh","arun@mail.com");
		Student student3 = new Student("Dilip","Rao","dilip@mail.com");

		//save multiple student obj
		System.out.println("saving multiple obj");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create Student object
		System.out.println("Creating Student obj...");
		Student tempStudent = new Student("Avinash","Kumar","avi@gmail.com");
		//save student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);
		// displayed id of saved Student
		System.out.println("Student id. Generated id: "+ tempStudent.getId());
	}


}
