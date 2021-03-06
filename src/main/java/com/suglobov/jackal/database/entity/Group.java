package com.suglobov.jackal.database.entity;

import javax.persistence.*;

/**
 * Created by cactu on 31.03.2017.
 */
@Entity
@Table(name = "group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private int course;

    /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Student> students;*/

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    //    public Set<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }

    @Override
    public String toString() {
        return String.format("Group[id=%d, name='%s']", id, name);
    }
}
