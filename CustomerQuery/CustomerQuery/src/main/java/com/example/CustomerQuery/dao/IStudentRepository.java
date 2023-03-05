package com.example.CustomerQuery.dao;

import com.example.CustomerQuery.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select * from tbl_student where first_name=:firstName and last_name=:lastName",nativeQuery = true)
    List<Student> findStudentByfirstNameandLastName(String firstName,String lastName);

    @Query(value = "select * from tbl_student where first_name=:firstName or last_name=:lastName",nativeQuery = true)
    List<Student> findStudentByfirstNameOrLastName(String firstName, String lastName);
    @Query(value = "select * from tbl_student where first_name=:firstName",nativeQuery = true)
    List<Student> findStudentByfirstName(String firstName);
    @Query(value = "select * from tbl_student where admission_date between :startDate and :endDate",nativeQuery = true)
    List<Student> findStudentByDate(Date startDate, Date endDate);
    @Query(value = "select * from tbl_student where age<:age",nativeQuery = true)
    List<Student> findStudentByAgelessthan(Integer age);
    @Query(value = "select * from tbl_student where age>:age",nativeQuery = true)
    List<Student> findStudentByAgemorethan(Integer age);
    @Query(value = "select * from tbl_student where age<=:age",nativeQuery = true)
    List<Student> findStudentByAgelessthanorequals(Integer age);
    @Query(value = "select * from tbl_student where age>=:age",nativeQuery = true)
    List<Student> findStudentByAgemorethanorequals(Integer age);
    @Query(value = "select * from tbl_student where admission_date>:date",nativeQuery = true)
    List<Student> findStudentByDatemorethan(Date date);
    @Query(value = "select * from tbl_student where admission_date<:date",nativeQuery = true)
    List<Student> findStudentByDatelessthan(Date date);
    @Query(value = "select * from tbl_student where age is null ",nativeQuery = true)
    List<Student> findStudentwhoseageisnull();
    @Query(value = "select * from tbl_student where age is not null ",nativeQuery = true)
    List<Student> findStudentwhoseageisnotnull();
    @Query(value = "select * from tbl_student where first_name like %:firstName",nativeQuery = true)
    List<Student> findStudentwherefirstNamebelike(String firstName);
    @Query(value = "select * from tbl_student where first_name not like %:firstName",nativeQuery = true)
    List<Student> findStudentwherefirstNamenotlike(String firstName);
    @Query(value = "select * from tbl_student where first_name like :firstName%",nativeQuery = true)
    List<Student> findStudentwherefirstNamestartswith(String firstName);
    @Query(value = "select * from tbl_student where first_name like %:firstName",nativeQuery = true)
    List<Student> findStudentwherefirstNameendswith(String firstName);
    @Query(value = "select * from tbl_student where first_name like %:name%",nativeQuery = true)
    List<Student> findStudentByfirstnamecontaining(String name);
    @Query(value = "select * from tbl_student where first_name not like %:name%",nativeQuery = true)
    List<Student> findStudentByfirstnamenotcontaining(String name);
    @Query(value = "select * from tbl_student where last_name <> :lastName",nativeQuery = true)
    List<Student> findStudentBylastnamenot(String lastName);
    @Query(value = "select * from tbl_student where age =:age order by last_name desc",nativeQuery = true)
    List<Student> findStudentbyagedesclastname(Integer age);
    @Query(value = "select * from tbl_student where age in(:ages)",nativeQuery = true)
    List<Student> findStudentbyagein(List<Integer> ages);
    @Query(value = "select * from tbl_student where age not in(:ages)",nativeQuery = true)
    List<Student> findStudentbyagenotin(List<Integer> ages);
    @Query(value = "select * from tbl_student where active=true",nativeQuery = true)
    List<Student> getactivestudent();
    @Query(value = "select * from tbl_student where active=false",nativeQuery = true)
    List<Student> getinactivestudent();

    @Query(value = "select * from tbl_student where UPPER(first_name)=UPPER(:name)",nativeQuery = true)
    List<Student> studentignorecase(String name);
}
