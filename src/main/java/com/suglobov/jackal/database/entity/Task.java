package com.suglobov.jackal.database.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cactu on 31.03.2017.
 */
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discipleId")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discipleId")
    private Disciple disciple;

    @Column(name = "variantscount")
    private int variantsCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Person author;

    @Column(name = "date")
    private Date date;

    public Task() {
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Disciple getDisciple() {
        return disciple;
    }

    public void setDisciple(Disciple disciple) {
        this.disciple = disciple;
    }

    public int getVariantsCount() {
        return variantsCount;
    }

    public void setVariantsCount(int variantsCount) {
        this.variantsCount = variantsCount;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Task[id=%d, name='%s']", id, name);
    }
}
