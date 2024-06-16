package com.example.CrudOperations.Request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentRequestDTO {

    private Integer id;

    private String name;

    private String pno;

    private String studentClass;

    private String studentMentor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentMentor() {
        return studentMentor;
    }

    public void setStudentMentor(String studentMentor) {
        this.studentMentor = studentMentor;
    }
}
