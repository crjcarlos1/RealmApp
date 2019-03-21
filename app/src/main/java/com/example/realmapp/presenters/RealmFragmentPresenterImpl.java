package com.example.realmapp.presenters;

import android.content.Context;

import com.example.realmapp.interactors.RealmFragmentInteractorImpl;
import com.example.realmapp.interfaces.RealmFragmentInteractor;
import com.example.realmapp.interfaces.RealmFragmentPresenter;
import com.example.realmapp.interfaces.RealmFragmentView;
import com.example.realmapp.realm.models.Materia;
import com.example.realmapp.realm.models.Student;

import java.util.List;

public class RealmFragmentPresenterImpl implements RealmFragmentPresenter {

    private RealmFragmentInteractor interactor;
    private RealmFragmentView view;

    public RealmFragmentPresenterImpl(Context context, RealmFragmentView view) {
        this.view = view;
        interactor = new RealmFragmentInteractorImpl(context, this);
    }


    /**
     * Lo que se le solicita al interactor
     */

    @Override
    public void requestAllStudents() {
        if (view != null) {
            interactor.getAllStudents();
        }
    }

    @Override
    public void saveStudent(String studentName, String studentEnrrolment, String career) {
        if (view != null) {
            interactor.saveStudent(studentName, studentEnrrolment, career);
        }
    }

    @Override
    public void deleteStudentByEnrrolment(String enrrolment) {
        if (view != null) {
            interactor.deleteStudentByEnrrolment(enrrolment);
        }
    }

    @Override
    public void getOnlyCarlos() {
        if (view != null) {
            interactor.getOnlyCarlosStudents();
        }
    }

    @Override
    public void getStudentsWithIdGreaterThan20() {
        if (view != null) {
            interactor.getStudentsWithIdGreaterThan20();
        }
    }

    @Override
    public void getOnlyCarlosWithIdGreaterThan5() {
        if (view != null) {
            interactor.getOnlyCarlosWithIdGreaterThan5();
        }
    }

    @Override
    public void updateStudentNameByEnrrolment(String enrrolment, String newStudentName) {
        if (view != null) {
            interactor.updateStudentNameByEnrrolment(enrrolment, newStudentName);
        }
    }

    @Override
    public void addSubjectByEnrrolment(String enrrolment, String subjectName, String areaSubject) {
        if (view != null) {
            interactor.addSubjectByEnrrolment(enrrolment, subjectName, areaSubject);
        }
    }

    @Override
    public void updateSubjectNameByStudentEnrrolment(String enrrolment, String currentSubjectName, String newSubjectName) {
        if (view != null) {
            interactor.updateSubjectNameByStudentEnrrolment(enrrolment, currentSubjectName, newSubjectName);
        }
    }

    @Override
    public void deleteSubjectByStudentEnrrolmentAndName(String enrrolment, String subjectName) {
        if (view != null) {
            interactor.deleteSubjectByStudentEnrrolmentAndName(enrrolment, subjectName);
        }
    }

    @Override
    public void getAllSubjects() {
        if (view != null) {
            interactor.getAllSubjects();
        }
    }

    /**
     * Lo que se envía al view
     */

    @Override
    public void setStudentsToView(List<Student> students) {
        if (view != null) {
            view.showStudents(students);
        }
    }

    @Override
    public void setMessageToView(String message) {
        if (view != null) {
            view.showMessage(message);
        }
    }

    @Override
    public void setSubjectsToView(List<Materia> materias) {
        if (view != null) {
            view.showSubjects(materias);
        }
    }

}
