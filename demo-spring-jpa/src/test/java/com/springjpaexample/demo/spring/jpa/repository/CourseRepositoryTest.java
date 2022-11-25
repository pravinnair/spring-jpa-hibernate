package com.springjpaexample.demo.spring.jpa.repository;

import com.springjpaexample.demo.spring.jpa.entity.Course;
import com.springjpaexample.demo.spring.jpa.entity.Student;
import com.springjpaexample.demo.spring.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCourses(){
//        List<Course> courseList = courseRepository.findAll();
//        System.out.println("Print Courses :"+ courseList);
        System.out.println("Print Courses :");
    }

//    @Test
//    public void saveCourseWithTeacher(){
//        Teacher teacher=Teacher
//                .builder()
//                .firstName("Ashok")
//                .lastName("Singh")
//                .build();
//        Course course=Course
//                .builder()
//                .title("Python")
//                .credit(5)
//                .teacher(teacher)
//                .build();
//
//        courseRepository.save(course);
//    }
//
//    @Test
//    public void findAllPagination(){
//        Pageable firstPageWithThreeRecords=
//                PageRequest.of(0,3);
//        Pageable firstPageWithTwoRecords=
//                PageRequest.of(0,2);
//
//        List<Course> courses=courseRepository
//                .findAll(firstPageWithThreeRecords)
//                .getContent();
//        Integer count=courseRepository
//                .findAll(firstPageWithThreeRecords)
//                        .getTotalPages();
//        System.out.println("Print list of paged courses :"+ courses);
//    }
//
//    @Test
//    public void findAllSorting(){
//        Pageable sortByTitle=
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("title").descending()
//                );
//
//        Pageable sortByCredit=
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("credit")
//                );
//        Pageable sortByTitleAndCredit=
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("title")
//                                .descending()
//                                .and(Sort.by("credit")));
//
//        List<Course> courses= courseRepository.findAll(sortByTitleAndCredit).getContent();
//        System.out.println("Print Sorted By Title and Credit :"+courses);
//    }

//    @Test
//    public void customPagination(){
//        Pageable firstPageTenRecords=
//                PageRequest.of(0,10);
//        List<Course> courses=
//                courseRepository
//                .findByTitleContaining("D",firstPageTenRecords)
//                .getContent();
//        System.out.println("Print custom page output :"+ courses);
//    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher
                .builder()
                .firstName("Lisa")
                .lastName("Roy")
                .build();
        Student student= Student.builder()
                .firstName("Tejas")
                .lastName("Rao")
                .emailId("tejas@gmail.com")
                .build();
        Course course=Course
                .builder()
                .title("C#")
                .credit(5)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}