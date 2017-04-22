package com.suglobov.jackal.database.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by cactu on 31.03.2017.
 */
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

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
