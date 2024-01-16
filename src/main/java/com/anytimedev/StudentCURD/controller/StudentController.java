package com.anytimedev.StudentCURD.controller;

import com.anytimedev.StudentCURD.entity.Student;
import com.anytimedev.StudentCURD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.insert(student);
    }

    @GetMapping("getStudentById/{id}")
    public Object getStudentById(@PathVariable("id") int id){
        var student = studentService.getById(id);
        if(student != null) {
            return student;
        }

        return "Student Not Found";
    }

    @GetMapping("getAllStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        var b = studentService.deleteStudent(id);
        if (b) {
            return "Student deleted successfully";
        }

        return "Student Not Found";
    }

    @PutMapping("updateStudent")
    public Object updateStudent(@RequestBody Student student) {
        var stud = studentService.updateStudent(student);
        if(stud != null) {
            return stud;
        }
        return "Student Not Found";
    }

}
