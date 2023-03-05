package com.example.CustomerQuery.dao;

import com.example.CustomerQuery.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select * from tbl_student where first_name=:firstName and active=true",nativeQuery = true)
    List<Student> findStudentByfirstName(String firstName);

    @Query(value = "select * from tbl_student where last_name=:lastName and active=true",nativeQuery = true)
    List<Student> findStudentBylastName(String lastName);
    @Query(value = "select * from tbl_student where age=:age and active=true",nativeQuery = true)
    List<Student> findStudentByAge(Integer age);
    @Query(value = "select * from tbl_student where student_id=:id and active=true",nativeQuery = true)
    List<Student> findStudentById(Integer id);
    @Query(value = "select * from tbl_student where admission_date=:date and active=true",nativeQuery = true)
    List<Student> findStudentByDate(Date date);
    @Query(value = "select * from tbl_student where active=:active",nativeQuery = true)
    List<Student> findStudentByActive(Boolean active);
    @Query(value = "select * from tbl_student",nativeQuery = true)
    List<Student> findAllbyQuery();
}
