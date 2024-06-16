package com.example.CrudOperations.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_pno")
    private String pno;

    @Column(name = "student_class")
    private String studentClass;

    @Column(name = "student_mentor")
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
