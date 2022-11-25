package com.springjpaexample.demo.spring.jpa.repository;

import com.springjpaexample.demo.spring.jpa.entity.Course;
import com.springjpaexample.demo.spring.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course=Course.builder()
                .title("Science")
                .credit(10)
                .build();

        CourseMaterial material=CourseMaterial.builder()
                .url("www.yahoo.com")
                .course(course)
                .build();

        repository.save(material);
    }

    @Test
    public void printGetCourseMaterials(){
        List<CourseMaterial> courseMaterial=repository.findAll();
        System.out.println("PRINT COURSE MATERIAL :"+ courseMaterial);
    }
}