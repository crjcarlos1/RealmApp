package com.example.realmapp.interactors;

import com.example.realmapp.realm.utils.RealmConstants;

public class Utils {

    public static final String validateStudentData(String studentName, String studentEnrrolment, String studentCareer) {
        if (studentName == null || studentName.length() == 0 ||
                studentEnrrolment == null || studentEnrrolment.length() == 0 ||
                studentCareer == null || studentCareer.length() == 0) {
            return RealmConstants.FAILTURE;
        } else {
            return RealmConstants.SUCCESS;
        }
    }

    public static final String validateEnrrolment(String enrrolment) {
        if (enrrolment == null || enrrolment.length() == 0) {
            return RealmConstants.FAILTURE;
        } else {
            return RealmConstants.SUCCESS;
        }
    }

    public static final String validateName(String name) {
        if (name == null || name.length() == 0) {
            return RealmConstants.FAILTURE;
        } else {
            return RealmConstants.SUCCESS;
        }
    }

    public static final String validateMateria(String subjectName, String areaSubject) {
        if (subjectName == null || subjectName.length() == 0 || areaSubject == null || areaSubject.length() == 0) {
            return RealmConstants.FAILTURE;
        } else {
            return RealmConstants.SUCCESS;
        }
    }

    public static final String validateSubject(String subjectName) {
        if (subjectName == null || subjectName.length() == 0) {
            return RealmConstants.FAILTURE;
        } else {
            return RealmConstants.SUCCESS;
        }
    }

}
