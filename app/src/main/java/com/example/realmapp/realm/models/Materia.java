package com.example.realmapp.realm.models;

import io.realm.RealmObject;

public class Materia extends RealmObject {

    private String studentEnrrolment;
    private String subjectName;
    private String areaSubject;

    public Materia() {
    }

    public String getStudentEnrrolment() {
        return studentEnrrolment;
    }

    public void setStudentEnrrolment(String studentEnrrolment) {
        this.studentEnrrolment = studentEnrrolment;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAreaSubject() {
        return areaSubject;
    }

    public void setAreaSubject(String areaSubject) {
        this.areaSubject = areaSubject;
    }

}
