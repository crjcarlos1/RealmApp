package com.example.realmapp.interfaces;

import com.example.realmapp.realm.models.Materia;
import com.example.realmapp.realm.models.Student;

import java.util.List;

public interface RealmFragmentView {

    void showStudents(List<Student> students);

    void showSubjects(List<Materia> materias);

    void showMessage(String message);

}
