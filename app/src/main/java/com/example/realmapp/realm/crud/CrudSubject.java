package com.example.realmapp.realm.crud;

import com.example.realmapp.realm.models.Materia;
import com.example.realmapp.realm.models.Student;
import com.example.realmapp.realm.utils.RealmConstants;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CrudSubject {

    public static final String addSubjectByStudentEnrrolment(String enrrolment, Materia materia) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Student student = realm.where(Student.class).equalTo(RealmConstants.COLUMN_STUDENT_ENRROLMENT, enrrolment).findFirst();
        if (student != null) {
            student.getMaterias().add(materia);
            realm.insertOrUpdate(student);
            realm.commitTransaction();
            return "Se agrego materia de forma correcta a la matrícula " + enrrolment;
        } else {
            realm.commitTransaction();
            return "No se agrego curso porque no existe estudiante con matrícula: " + enrrolment;
        }
    }

    public static final String updateSubjectNameByStudentEnrrolment(String enrrolment, String currentSubjectName, String newSubjectName) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Student student = realm.where(Student.class).equalTo(RealmConstants.COLUMN_STUDENT_ENRROLMENT, enrrolment).findFirst();
        if (student != null) {
            Materia materia = realm.where(Materia.class)
                    .equalTo(RealmConstants.COLUMN_STUDENT_ENRROLMENT, enrrolment)
                    .equalTo(RealmConstants.COLUMN_SUBJECT_NAME, currentSubjectName).findFirst();
            if (materia != null) {
                materia.setSubjectName(newSubjectName);
                realm.insertOrUpdate(materia);
                realm.commitTransaction();
                return "Se actualizo el nombre de la materia correctamente";
            } else {
                realm.commitTransaction();
                return "No se pudo actualizar porque la matrícula no tiene la materia " + currentSubjectName;
            }

        } else {
            realm.commitTransaction();
            return "No se pudo actualizar porque no existe la matrícula " + enrrolment;
        }
    }

    public static final String deleteSubjectByStudentEnrrolmentAndName(String enrrolment, String subjectName) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Student student = realm.where(Student.class).equalTo(RealmConstants.COLUMN_STUDENT_ENRROLMENT, enrrolment).findFirst();
        if (student != null) {
            Materia materia = realm.where(Materia.class).equalTo(RealmConstants.COLUMN_STUDENT_ENRROLMENT, enrrolment)
                    .equalTo(RealmConstants.COLUMN_SUBJECT_NAME, subjectName).findFirst();
            if (materia != null) {
                materia.deleteFromRealm();
                realm.commitTransaction();
                return "La materia se elimino de forma correcta";
            } else {
                realm.commitTransaction();
                return "La matrícula ingresada no cuenta con esa materia";
            }
        } else {
            realm.commitTransaction();
            return "No existe la matrícula que ingreso";
        }
    }

    public static final List<Materia> getAllSubjects() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Materia> materias = realm.where(Materia.class).findAll();
        if (materias == null || materias.size() == 0) {
            return null;
        } else {
            return materias;
        }
    }

}
