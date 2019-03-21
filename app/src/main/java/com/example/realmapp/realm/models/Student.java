package com.example.realmapp.realm.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Student extends RealmObject {

    @PrimaryKey
    private int studentId;
    private String studentName;
    private String studentEnrrolment;
    private String career;
    private RealmList<Materia> materias;

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEnrrolment() {
        return studentEnrrolment;
    }

    public void setStudentEnrrolment(String studentEnrrolment) {
        this.studentEnrrolment = studentEnrrolment;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public RealmList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(RealmList<Materia> materias) {
        this.materias = materias;
    }

}
