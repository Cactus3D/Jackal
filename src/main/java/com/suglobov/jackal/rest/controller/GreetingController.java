package com.suglobov.jackal.rest.controller;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.Student;
import com.suglobov.jackal.database.service.GroupService;
import com.suglobov.jackal.database.service.StudentService;
import com.suglobov.jackal.rest.model.ShowFullBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private StudentService studentService;
    private GroupService groupService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping("/greeting")
    public ShowFullBase greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Student student = new Student();
        student.setName("Вадим");
        student.setPatronymic("Алекссевич");
        student.setSurname("Данилов");
        Group group = groupService.getById(0);
        student.setGroup(group);
        studentService.addStudent(student);
        List<Student> students = studentService.getAll();
        List<Group> groups = groupService.getAll();
        return new ShowFullBase(students, groups);
        //return new Greeting(counter.incrementAndGet(),
        //String.format(template, name));
    }

    @RequestMapping("/greeting/spec")
    public ShowFullBase greetingSpec(@RequestParam(value = "name") String name) {
        Group group = groupService.getByName(name);
        Group g = groupService.getById(0);
        //groupService.editGroup(g);
        System.out.println(g.toString());
        List<Student> students = new LinkedList<>();
        if (g != null) {
            students = studentService.getInGroup(g);
        }
        List<Group> groups = new LinkedList<>();
        groups.add(g);
        return new ShowFullBase(students, groups);
    }
}