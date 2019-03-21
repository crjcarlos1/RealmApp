package com.example.realmapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.realmapp.R;
import com.example.realmapp.interfaces.RealmFragmentPresenter;
import com.example.realmapp.interfaces.RealmFragmentView;
import com.example.realmapp.presenters.RealmFragmentPresenterImpl;
import com.example.realmapp.realm.models.Materia;
import com.example.realmapp.realm.models.Student;

import java.util.List;

public class RealmFragment extends Fragment  implements View.OnClickListener, RealmFragmentView {
    public static final String TAG = RealmFragment.class.getSimpleName();

    /**
     * EditText, Buttons de alumnos
     */
    private EditText edtStudentName, edtStudentEnrrolment, edtStudentCareer;
    private Button btnSaveStudent, btnShowAllStudents, btnShowCarlosStudents, btnShowStudentWithIdGreaterThan20,
            btnShowOnlyCarlosWithIdGreaterThan5, btnDeleteStudentByEnrollment, btnUpdateStudentNameByEnrrolment;

    /**
     * EditText,Buttons de materias
     */
    private EditText edtMateria, edtAreaDeMateria, edtUpdateSubjectName;
    private Button btnAddSubjectByStudentId, btnUpdateSubjectNameByStudentId, btnDeleteSubjectByStudentIdAndName, btnShowAllSubjects;

    private RealmFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.realm_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        edtStudentName = (EditText) view.findViewById(R.id.edtStudentName);
        edtStudentEnrrolment = (EditText) view.findViewById(R.id.edtStudentEnrrolment);
        edtStudentCareer = (EditText) view.findViewById(R.id.edtStudentCareer);
        edtMateria = (EditText) view.findViewById(R.id.edtMateria);
        edtAreaDeMateria = (EditText) view.findViewById(R.id.edtAreaDeMateria);
        edtUpdateSubjectName = (EditText) view.findViewById(R.id.edtUpdateSubjectName);

        btnSaveStudent = (Button) view.findViewById(R.id.btnSaveStuden);
        btnShowAllStudents = (Button) view.findViewById(R.id.btnShowAllStudents);
        btnShowCarlosStudents = (Button) view.findViewById(R.id.btnShowCarlosStudents);
        btnShowStudentWithIdGreaterThan20 = (Button) view.findViewById(R.id.btnShowStudentWithIdGreaterThan20);
        btnShowOnlyCarlosWithIdGreaterThan5 = (Button) view.findViewById(R.id.btnShowOnlyCarlosWithIdGreaterThan5);
        btnDeleteStudentByEnrollment = (Button) view.findViewById(R.id.btnDeleteStudentByEnrollment);
        btnUpdateStudentNameByEnrrolment = (Button) view.findViewById(R.id.btnUpdateStudentNameByEnrrolment);
        btnAddSubjectByStudentId = (Button) view.findViewById(R.id.btnAddSubjectByStudentEnrrolment);
        btnUpdateSubjectNameByStudentId = (Button) view.findViewById(R.id.btnUpdateSubjectNameByStudentEnrrolment);
        btnDeleteSubjectByStudentIdAndName = (Button) view.findViewById(R.id.btnDeleteSubjectByStudentEnrrolmentAndName);
        btnShowAllSubjects = (Button) view.findViewById(R.id.btnShowAllSubjects);

        btnSaveStudent.setOnClickListener(this);
        btnShowAllStudents.setOnClickListener(this);
        btnShowCarlosStudents.setOnClickListener(this);
        btnShowStudentWithIdGreaterThan20.setOnClickListener(this);
        btnShowOnlyCarlosWithIdGreaterThan5.setOnClickListener(this);
        btnDeleteStudentByEnrollment.setOnClickListener(this);
        btnUpdateStudentNameByEnrrolment.setOnClickListener(this);
        btnAddSubjectByStudentId.setOnClickListener(this);
        btnUpdateSubjectNameByStudentId.setOnClickListener(this);
        btnDeleteSubjectByStudentIdAndName.setOnClickListener(this);
        btnShowAllSubjects.setOnClickListener(this);

        presenter = new RealmFragmentPresenterImpl(getContext(), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowAllSubjects:
                showAllSubjects();
                break;
            case R.id.btnAddSubjectByStudentEnrrolment:
                addSubjectByStudentEnrrolment();
                break;
            case R.id.btnUpdateSubjectNameByStudentEnrrolment:
                updateSubjectNameByStudentEnrrolment();
                break;
            case R.id.btnDeleteSubjectByStudentEnrrolmentAndName:
                deleteSubjectByStudentEnrrolmentAndName();
                break;
            case R.id.btnSaveStuden:
                saveStudent();
                break;
            case R.id.btnShowAllStudents:
                showAllStudents();
                break;
            case R.id.btnShowCarlosStudents:
                showOnlyCarlosStudents();
                break;
            case R.id.btnShowStudentWithIdGreaterThan20:
                ShowStudentWithIdGreaterThan20();
                break;
            case R.id.btnShowOnlyCarlosWithIdGreaterThan5:
                ShowOnlyCarlosWithIdGreaterThan5();
                break;
            case R.id.btnDeleteStudentByEnrollment:
                DeleteStudentByEnrollment();
                break;
            case R.id.btnUpdateStudentNameByEnrrolment:
                updateStudentNameByEnrrolment();
                break;
        }
    }

    private void showAllSubjects() {
        presenter.getAllSubjects();
    }

    private void deleteSubjectByStudentEnrrolmentAndName() {
        presenter.deleteSubjectByStudentEnrrolmentAndName(edtStudentEnrrolment.getText().toString(), edtMateria.getText().toString());
    }

    private void updateSubjectNameByStudentEnrrolment() {
        presenter.updateSubjectNameByStudentEnrrolment(edtStudentEnrrolment.getText().toString(),
                edtMateria.getText().toString(), edtUpdateSubjectName.getText().toString());
    }

    private void addSubjectByStudentEnrrolment() {
        presenter.addSubjectByEnrrolment(edtStudentEnrrolment.getText().toString(),
                edtMateria.getText().toString(), edtAreaDeMateria.getText().toString());
    }

    private void updateStudentNameByEnrrolment() {
        presenter.updateStudentNameByEnrrolment(edtStudentEnrrolment.getText().toString(), edtStudentName.getText().toString());
    }

    private void DeleteStudentByEnrollment() {
        presenter.deleteStudentByEnrrolment(edtStudentEnrrolment.getText().toString());
    }

    private void ShowOnlyCarlosWithIdGreaterThan5() {
        presenter.getOnlyCarlosWithIdGreaterThan5();
    }

    private void ShowStudentWithIdGreaterThan20() {
        presenter.getStudentsWithIdGreaterThan20();
    }

    private void showOnlyCarlosStudents() {
        presenter.getOnlyCarlos();
    }

    private void showAllStudents() {
        presenter.requestAllStudents();
    }

    private void saveStudent() {
        presenter.saveStudent(edtStudentName.getText().toString(), edtStudentEnrrolment.getText().toString(), edtStudentCareer.getText().toString());
    }

    @Override
    public void showStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Log.e("STUDENT_TAG", "Id: " + students.get(i).getStudentId() + ", Name: " + students.get(i).getStudentName()
                    + ", Carrera: " + students.get(i).getCareer() + ", Matrícula: " + students.get(i).getStudentEnrrolment());
            List<Materia> materias = students.get(i).getMaterias();
            if (materias == null || materias.size() == 0) {
                Log.e("STUDENT_TAG", students.get(i).getStudentName() + " no cuenta con materias.");
            } else {
                Log.e("STUDENT_TAG", "Las materias de " + students.get(i).getStudentName() + " son:");
                for (int j = 0; j < materias.size(); j++) {
                    Log.e("STUDENT_TAG", "--> " + materias.get(j).getSubjectName());
                }
            }
            Log.e("STUDENT_TAG", "***********************");
            Log.e("STUDENT_TAG", "***********************");
            Log.e("STUDENT_TAG", "***********************");
        }
    }

    @Override
    public void showSubjects(List<Materia> materias) {
        for (int i = 0; i < materias.size(); i++) {
            Log.e("SUBJECTS", "--> " + materias.get(i).getSubjectName());
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
