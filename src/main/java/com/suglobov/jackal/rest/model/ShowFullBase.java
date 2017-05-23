package com.suglobov.jackal.rest.model;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.Student;

import java.util.List;

/**
 * Created by Cactus3D on 05.04.2017.
 */
public class ShowFullBase {

    private String students = "";
    private String groups = "";

    public ShowFullBase(List<Student> students, List<Group> groups) {
        for (Student stud :
                students) {
            Group group = stud.getGroup();
            this.students += stud.toString() + " in " + group.toString();
        }
        for (Group group :
                groups) {
            this.groups += group.toString() + " ";
        }
    }

    public String getStudents() {
        return students;
    }

    public String getGroups() {
        return groups;
    }
}
