package com.suglobov.jackal.database.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Cactus3D
 */
@Entity
@Table(name = "link_group_student")
public class LinkGroupStudent {

    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groupId")
    private Group group;

    @Cascade({CascadeType.ALL})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personId")
    private Person student;

    @Column(name = "variant")
    private int variant;

    public LinkGroupStudent() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public int getVariant() {
        return variant;
    }

    public void setVariant(int variant) {
        this.variant = variant;
    }
}
