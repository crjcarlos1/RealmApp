package com.example.realmapp.interfaces;

public interface RealmFragmentInteractor {

    void saveStudent(String studentName, String studentEnrrolment, String career);

    void getAllStudents();

    void deleteStudentByEnrrolment(String enrrolment);

    void getOnlyCarlosStudents();

    void getStudentsWithIdGreaterThan20();

    void getOnlyCarlosWithIdGreaterThan5();

    void updateStudentNameByEnrrolment(String enrrolment, String newStudentName);

    void addSubjectByEnrrolment(String enrrolment, String subjectName, String areaSubject);

    void updateSubjectNameByStudentEnrrolment(String enrrolment, String currentSubjectName, String newSubjectName);

    void deleteSubjectByStudentEnrrolmentAndName(String enrrolment, String subjectName);

    void getAllSubjects();

}
