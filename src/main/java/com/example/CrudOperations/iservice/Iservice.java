package com.example.CrudOperations.iservice;

import com.example.CrudOperations.Entity.Student;
import com.example.CrudOperations.Request.StudentRequestDTO;
import com.example.CrudOperations.Response.StudentResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface Iservice {
    public List<StudentResponseDTO> create(List<StudentRequestDTO> studentRequestDTO);

    public List<StudentResponseDTO> getById(List<Integer> id);

    public List<StudentResponseDTO> update(List<StudentRequestDTO> studentRequestDTOS);

    public void delete(List<Integer> id);

    List<Student> orderByName(String sorting);

    List<StudentResponseDTO> findByName(String studentName);

    Map<String, List<Student>> findByKeys();

    Page<Student> getPageableByStudent(int sort, int pageSize, String field);
}
