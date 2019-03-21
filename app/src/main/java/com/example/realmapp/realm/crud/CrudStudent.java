package com.example.realmapp.realm.crud;

import android.util.Log;

import com.example.realmapp.realm.models.Student;
import com.example.realmapp.realm.utils.RealmConstants;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CrudStudent {

    private static final String TAG = "CrudStudent";

    private final static int calculateIndex() {
        Realm realm = Realm.getDefaultInstance();
        Number number = realm.where(Student.class).max(RealmConstants.COLUMN_STUDENT_ID);
        int nextId;
        if (number == null) {
            nextId = 0;
        } else {
            nextId = number.intValue() + 1;
        }
        return nextId;
    }

    public final static String saveStudent(Student student) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        int studentId = CrudStudent.calculateIndex();
        Student realmStudent = realm.createObject(Student.class, studentId);
        realmStudent.setStudentName(student.getStudentName());
        realmStudent.setCareer(student.getCareer());
        realmStudent.setStudentEnrrolment(student.getStudentEnrrolment());
        realm.commitTransaction();
        return RealmConstants.SUCCESS;
    }

    public static final List<Student> getAllStudents() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Student> students = realm.where(Student.class).findAll();
        if (students == null || students.size() == 0) {
            Log.e(TAG, "No se encontraron estudiantes en la base de datos");
            return null;
        } else {
            Log.e(TAG, "Se encontraron " + students.size() + " estudiantes en la base de datos");
            return students;
        }
    }

    public static final String deleteStudentByEnrrolment(String enrrolment) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Student student = realm.where(Student.class).equalTo(RealmConstants.COLUMN_STUDENT_ENRROLMENT, enrrolment).findFirst();

        if (student != null) {
            student.deleteFromRealm();
            realm.commitTransaction();
            return "Se borró de forma correcta al estudiante con matrícula " + enrrolment;

        } else {
            realm.commitTransaction();
            return "No se eliminó al estudiante porque no existe la matrícula " + enrrolment;
        }
    }

    public static final List<Student> getOnlyCarlosStudents() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Student> students = realm.where(Student.class).equalTo(RealmConstants.COLUMN_STUDENT_NAME, "carlos").findAll();
        if (students == null || students.size() == 0) {
            return null;
        } else {
            return students;
        }
    }

    public static final List<Student> getStudentWithIdGreaterThan20() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Student> students = realm.where(Student.class).greaterThan(RealmConstants.COLUMN_STUDENT_ID, 20).findAll();
        if (students == null || students.size() == 0) {
            return null;
        } else {
            return students;
        }
    }

    public static final List<Student> getOnlyCarlosWithIdGreaterThan5() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Student> students = realm.where(Student.class)
                .greaterThan(RealmConstants.COLUMN_STUDENT_ID, 5)
                .equalTo(RealmConstants.COLUMN_STUDENT_NAME, "carlos")
                .findAll();
        if (students == null || students.size() == 0) {
            return null;
        } else {
            return students;
        }
    }

    public static final boolean updateStudentNameByEnrrolment(String enrrolment, String newStudentName) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Student student = realm.where(Student.class).equalTo(RealmConstants.COLUMN_STUDENT_ENRROLMENT, enrrolment).findFirst();
        if (student != null) {
            student.setStudentName(newStudentName);
            realm.insertOrUpdate(student);
            realm.commitTransaction();
            return true;
        } else {
            realm.commitTransaction();
            return false;
        }
    }

}
