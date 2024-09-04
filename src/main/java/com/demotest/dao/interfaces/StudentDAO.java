package com.demotest.dao.interfaces;

import com.demotest.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByFirstName(String lastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
