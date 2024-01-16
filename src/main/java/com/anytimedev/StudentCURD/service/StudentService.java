package com.anytimedev.StudentCURD.service;

import com.anytimedev.StudentCURD.entity.Student;

import java.util.List;

public interface StudentService {

    Student insert(Student student);

    Student getById(int id);

    List<Student> getAllStudent();

    Student updateStudent(Student student);

    Boolean deleteStudent(int id);

}
