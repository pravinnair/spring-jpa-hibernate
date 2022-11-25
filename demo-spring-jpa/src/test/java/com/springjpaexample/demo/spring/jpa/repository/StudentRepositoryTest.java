package com.springjpaexample.demo.spring.jpa.repository;

import com.springjpaexample.demo.spring.jpa.entity.Guardian;
import com.springjpaexample.demo.spring.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

//    @Test
//    public void saveStudent(){
//        Student student=Student.builder()
//                .emailId("testemail@gmail.com")
//                .firstName("demo")
//                .lastName("builder")
//                .guardianEmail("guardemail@gmail.com")
//                .guardianName("Harry")
//                .guardianMobile("9999999999")
//                .build();
//        studentRepository.save(student);
//    }

    @Test
    public void saveStudent(){
        Guardian guardian=Guardian.builder()
                .email("haggard@gmail.com")
                .name("Haggard")
                .mobile("9994563210")
                .build();

        Student student=Student.builder()
                .emailId("ramesh@gmail.com")
                .firstName("Ramesh")
                .lastName("Kumar")
                .guardian(guardian)
                .build();


        Guardian guardian2=Guardian.builder()
                .email("harry@gmail.com")
                .name("Harry")
                .mobile("8884585210")
                .build();

        Student student2=Student.builder()
                .emailId("sammy@gmail.com")
                .firstName("Sammy")
                .lastName("John")
                .guardian(guardian)
                .build();

//        studentRepository.save(student);
        List<Student> students= new ArrayList<Student>();
        students.add(student2);
        students.add(student);
        studentRepository.saveAll(students);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList= studentRepository.findAll();
        System.out.println("Student List: "+ studentList);

        List<Student> firstStudent= studentRepository.findByFirstName("Sammy");
        System.out.println("First Student"+ firstStudent);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("subash@gmail.com");
        System.out.println("JPQL result of first name is :"+ firstName);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("subash@gmail.com");
        System.out.println("JPQL Native Query result of first name is :"+ student.getFirstName());
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("subash@gmail.com");
        System.out.println("JPQL Native Query Named Param result of first name is :"+ student.getFirstName());
    }

    @Test
    public void printupdateStudentNameByEmailId(){
        int studentUpdate = studentRepository.updateStudentNameByEmailId("Thomas","subash@gmail.com");
        System.out.println("JPQL Native Query with Transactions result of first name is :"+ studentUpdate);
    }

}