package com.example.CrudOperations.Controller;

import com.example.CrudOperations.Entity.Student;
import com.example.CrudOperations.Repository.StudentRepository;
import com.example.CrudOperations.Request.StudentRequestDTO;
import com.example.CrudOperations.Response.StudentResponseDTO;
import java.util.List;
import java.util.Map;
import com.example.CrudOperations.iservice.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    Iservice iStudentService;

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/save")
    public List<StudentResponseDTO> save(@RequestBody List<StudentRequestDTO> studentRequestDTO){
        return iStudentService.create(studentRequestDTO);
    }

    @GetMapping("/get/{id}")
    public List<StudentResponseDTO> get(@PathVariable List<Integer> id){
        return iStudentService.getById(id);
    }

    @GetMapping("/gets")
    public List<StudentResponseDTO> get1(@RequestBody List<Integer> id){
        return iStudentService.getById(id);
    }

    @PutMapping("/update")
    public List<StudentResponseDTO> update(@RequestBody List<StudentRequestDTO> studentRequestDTOS){
        return iStudentService.update(studentRequestDTOS);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable List<Integer> id){
        iStudentService.delete(id);
    }

    @GetMapping("/orderByName")
    public List<Student> orderByName(@RequestParam String sorting) {
            return iStudentService.orderByName(sorting);
    }

    @GetMapping("/getName/{name}")
    public  List<StudentResponseDTO> findByName(@PathVariable String studentName) {
        return iStudentService.findByName(studentName);
    }

    @GetMapping("/getKeyValue")
    public Map<String,List<Student>> findByKeys() {
        return  iStudentService.findByKeys();
    }

    @GetMapping("/pagebyOrder")
    public Page<Student> getPageableByStudent(@RequestParam int sort,
                            @RequestParam int pageSize,@RequestParam String field) {
        return iStudentService.getPageableByStudent(sort, pageSize, field);
    }

}
