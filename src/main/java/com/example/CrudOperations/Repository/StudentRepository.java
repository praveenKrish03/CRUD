package com.example.CrudOperations.Repository;

import com.example.CrudOperations.Entity.Student;
import com.example.CrudOperations.Response.StudentResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByIdIn(List<Integer> id);

    @Query(value = "Select * from student order by student_name Asc",nativeQuery = true)
    List<Student> findByNameAsc();

    @Query(value = "Select * from student order by student_name Desc",nativeQuery = true)
    List<Student> findByNameDesc();

    List<Student>findByName(String name);
}
