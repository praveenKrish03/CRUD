package com.example.CrudOperations.Service;

import com.example.CrudOperations.Entity.Student;
import com.example.CrudOperations.Repository.StudentRepository;
import com.example.CrudOperations.Request.StudentRequestDTO;
import com.example.CrudOperations.Response.StudentResponseDTO;
import com.example.CrudOperations.iservice.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StudentService implements Iservice {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentResponseDTO> create(List<StudentRequestDTO> studentRequestDTO) {
        List<Student> studentList = studentRequestDTO.stream()
                .map(this::convertRequestToEntity).collect(Collectors.toList());
        List<Student> entity = studentRepository.saveAll(studentList);
        return entity.stream().map(this::convertEntityToResponse).collect(Collectors.toList());
    }


    public Student convertRequestToEntity(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setId(studentRequestDTO.getId());
        student.setName(studentRequestDTO.getName());
        student.setPno(studentRequestDTO.getPno());
        student.setStudentClass(studentRequestDTO.getStudentClass());
        student.setStudentMentor(studentRequestDTO.getStudentMentor());
        return student;
    }

    public StudentResponseDTO convertEntityToResponse(Student student) {
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setPno(student.getPno());
        responseDTO.setClassName(student.getStudentClass());
        responseDTO.setStaff(student.getStudentMentor());
        return responseDTO;
    }

    public List<StudentResponseDTO> getById(List<Integer> id) {
        List<Student> entity = studentRepository.findByIdIn(id);
        return entity.stream().map(this::convertEntityToResponse).collect(Collectors.toList());
    }

    public List<StudentResponseDTO> update(List<StudentRequestDTO> studentRequestDTOS) {
        List<StudentResponseDTO> responseDTOList = new ArrayList<>();
        studentRequestDTOS.stream().
                forEach(dto -> {
            Student entity = studentRepository.findById(dto.getId()).get();
            responseDTOList.add(convertEntityToResponse(entity));
        });
        return responseDTOList;
    }

    public void delete(List<Integer> id) {
        studentRepository.deleteAllById(id);
    }

    @Override
    public List<Student> orderByName(String sorting) {
        if(sorting.equalsIgnoreCase("Asc")) {
            return studentRepository.findByNameAsc();
        }
        else {
            return  studentRepository.findByNameDesc();
        }
    }

    @Override
    public List<StudentResponseDTO> findByName(String studentName) {
        List<Student> students = studentRepository.findByName(studentName);
        return students.stream().map(this::convertEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Student>> findByKeys() {
        return studentRepository.findAll().stream().collect(Collectors.groupingBy(Student::getName));
    }

    @Override
    public Page<Student> getPageableByStudent(int sort, int pageSize, String field) {
        Sort sorting = Sort.by(field).descending();
        Pageable pageable = PageRequest.of(sort, pageSize, sorting);
        return studentRepository.findAll(pageable);
    }

}
