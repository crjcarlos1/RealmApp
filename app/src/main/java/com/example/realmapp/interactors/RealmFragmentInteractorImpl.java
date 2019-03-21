package com.example.realmapp.interactors;

import android.content.Context;

import com.example.realmapp.interfaces.RealmFragmentInteractor;
import com.example.realmapp.interfaces.RealmFragmentPresenter;
import com.example.realmapp.realm.crud.CrudStudent;
import com.example.realmapp.realm.crud.CrudSubject;
import com.example.realmapp.realm.models.Materia;
import com.example.realmapp.realm.models.Student;
import com.example.realmapp.realm.utils.RealmConstants;

import java.util.List;

public class RealmFragmentInteractorImpl implements RealmFragmentInteractor {
    private static final String TAG = RealmFragmentInteractorImpl.class.getSimpleName();
    private Context context;
    private RealmFragmentPresenter presenter;

    public RealmFragmentInteractorImpl(Context context, RealmFragmentPresenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }


    @Override
    public void saveStudent(String studentName, String studentEnrrolment, String career) {
        String validation = Utils.validateStudentData(studentName, studentEnrrolment, career);
        if (validation.equals(RealmConstants.SUCCESS)) {
            Student student = new Student();
            student.setStudentName(studentName);
            student.setStudentEnrrolment(studentEnrrolment);
            student.setCareer(career);
            String isSaved = CrudStudent.saveStudent(student);
            if (isSaved.equals(RealmConstants.SUCCESS)) {
                presenter.setMessageToView("Se salvo correctamente");
            } else {
                presenter.setMessageToView("No se pudo salvar alestudiante");
            }
        } else {
            presenter.setMessageToView("Ingresa nombre, matrícula y carrera del estudiante para salvarlo");
        }
    }

    @Override
    public void getAllStudents() {
        List<Student> students = CrudStudent.getAllStudents();
        if (students == null || students.size() == 0) {
            presenter.setMessageToView("No se encontraron alumnos en la db");
        } else {
            presenter.setStudentsToView(students);
        }
    }

    @Override
    public void deleteStudentByEnrrolment(String enrrolment) {
        String validateEnrrolment = Utils.validateEnrrolment(enrrolment);
        if (validateEnrrolment.equals(RealmConstants.SUCCESS)) {
            String result = CrudStudent.deleteStudentByEnrrolment(enrrolment);
            presenter.setMessageToView(result);
        } else {
            presenter.setMessageToView("ingresa una matrícula válida");
        }
    }

    @Override
    public void getOnlyCarlosStudents() {
        List<Student> students = CrudStudent.getOnlyCarlosStudents();
        if (students == null || students.size() == 0) {
            presenter.setMessageToView("No hay alumnos llamados carlos");
        } else {
            presenter.setStudentsToView(students);
        }
    }

    @Override
    public void getStudentsWithIdGreaterThan20() {
        List<Student> students = CrudStudent.getStudentWithIdGreaterThan20();
        if (students == null || students.size() == 0) {
            presenter.setMessageToView("No hay alumnos con ID mayor a 20");
        } else {
            presenter.setStudentsToView(students);
        }
    }

    @Override
    public void getOnlyCarlosWithIdGreaterThan5() {
        List<Student> students = CrudStudent.getOnlyCarlosWithIdGreaterThan5();
        if (students == null || students.size() == 0) {
            presenter.setMessageToView("No hay alumnos carlos con id > 20");
        } else {
            presenter.setStudentsToView(students);
        }
    }

    @Override
    public void updateStudentNameByEnrrolment(String enrrolment, String newStudentName) {
        String enrrolmentValidation = Utils.validateEnrrolment(enrrolment);
        String newNameValidation = Utils.validateName(newStudentName);
        if (enrrolmentValidation.equals(RealmConstants.SUCCESS) && newNameValidation.equals(RealmConstants.SUCCESS)) {
            boolean result = CrudStudent.updateStudentNameByEnrrolment(enrrolment, newStudentName);
            if (result) {
                presenter.setMessageToView("Se actualizó correctament el alumno con matrícula " + enrrolment);
            } else {
                presenter.setMessageToView("No se actualizo porque no existe esa matrícula");
            }
        } else {
            presenter.setMessageToView("Ingresa una matrícula y un nombre nuevo para actualizar");
        }
    }

    @Override
    public void addSubjectByEnrrolment(String enrrolment, String subjectName, String areaSubject) {
        String enrrolmentValidation = Utils.validateEnrrolment(enrrolment);
        if (enrrolmentValidation.equals(RealmConstants.SUCCESS)) {
            String materiaValidation = Utils.validateMateria(subjectName, areaSubject);
            if (materiaValidation.equals(RealmConstants.SUCCESS)) {
                Materia materia = new Materia();
                materia.setSubjectName(subjectName);
                materia.setAreaSubject(areaSubject);
                materia.setStudentEnrrolment(enrrolment);
                String resultMessage = CrudSubject.addSubjectByStudentEnrrolment(enrrolment, materia);
                presenter.setMessageToView(resultMessage);
                materia = null;
            } else {
                presenter.setMessageToView("Ingresa nombre del curso y su área");
            }
        } else {
            presenter.setMessageToView("Ingresa la matricula del estudiante");
        }
    }

    @Override
    public void updateSubjectNameByStudentEnrrolment(String enrrolment, String currentSubjectName, String newSubjectName) {
        String enrrolmentValidation = Utils.validateEnrrolment(enrrolment);
        String currentSubjectNameValidation = Utils.validateSubject(currentSubjectName);
        String newSubjectNameValidation = Utils.validateSubject(newSubjectName);

        if (enrrolmentValidation.equals(RealmConstants.SUCCESS) &&
                currentSubjectNameValidation.equals(RealmConstants.SUCCESS) &&
                newSubjectNameValidation.equals(RealmConstants.SUCCESS)) {
            String result = CrudSubject.updateSubjectNameByStudentEnrrolment(enrrolment, currentSubjectName, newSubjectName);
            presenter.setMessageToView(result);
        } else {
            presenter.setMessageToView("Ingresa matrícula, curso actual y el nombre del nuevo curso para actualizar");
        }

    }

    @Override
    public void deleteSubjectByStudentEnrrolmentAndName(String enrrolment, String subjectName) {
        String enrrolmentValidation = Utils.validateEnrrolment(enrrolment);
        String subjectNameValidation = Utils.validateSubject(subjectName);
        if (enrrolmentValidation.equals(RealmConstants.SUCCESS) && subjectNameValidation.equals(RealmConstants.SUCCESS)) {
            String result = CrudSubject.deleteSubjectByStudentEnrrolmentAndName(enrrolment, subjectName);
            presenter.setMessageToView(result);
        } else {
            presenter.setMessageToView("Ingresa matrícula de estudiante y nombre de curso para eliminarlo");
        }
    }

    @Override
    public void getAllSubjects() {
        presenter.setSubjectsToView(CrudSubject.getAllSubjects());
    }

}
