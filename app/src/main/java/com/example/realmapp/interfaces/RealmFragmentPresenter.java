package com.example.realmapp.interfaces;

import com.example.realmapp.realm.models.Materia;
import com.example.realmapp.realm.models.Student;

import java.util.List;

public interface RealmFragmentPresenter {

    /**
     * Lo que enviamos al interactor
     */
    void requestAllStudents();

    void saveStudent(String studentName, String studentEnrrolment, String career);

    void deleteStudentByEnrrolment(String enrrolment);

    void getOnlyCarlos();

    void getStudentsWithIdGreaterThan20();

    void getOnlyCarlosWithIdGreaterThan5();

    void updateStudentNameByEnrrolment(String enrrolment, String newStudentName);

    void addSubjectByEnrrolment(String enrrolment, String subjectName, String areaSubject);

    void updateSubjectNameByStudentEnrrolment(String enrrolment, String currentSubjectName, String newSubjectName);

    void deleteSubjectByStudentEnrrolmentAndName(String enrrolment, String subjectName);

    void getAllSubjects();

    /**
     * Lo que enviamos al view
     */
    void setStudentsToView(List<Student> students);

    void setMessageToView(String message);

    void setSubjectsToView(List<Materia> materias);

}
