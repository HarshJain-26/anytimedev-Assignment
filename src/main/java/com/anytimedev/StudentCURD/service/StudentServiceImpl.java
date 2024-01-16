package com.anytimedev.StudentCURD.service;

import com.anytimedev.StudentCURD.entity.Student;
import com.anytimedev.StudentCURD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getById(int id) {
        Optional<Student> student =  studentRepository.findById(id);

        return student.orElse(null);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        int studentId = student.getStudentId();
        Optional<Student> studentOptional =  studentRepository.findById(studentId);

        if(studentOptional.isPresent()) {
            Student stud = studentOptional.get();

            if (Objects.nonNull(student.getStudentName()) && !"".equalsIgnoreCase(student.getStudentName())) {
                stud.setStudentName(student.getStudentName());
            }

            if (Objects.nonNull(student.getStudentEmail()) && !"".equalsIgnoreCase(student.getStudentEmail())) {
                stud.setStudentEmail(student.getStudentEmail());
            }

            if (Objects.nonNull(student.getStudentGender()) && !"".equalsIgnoreCase(student.getStudentGender())) {
                stud.setStudentGender(student.getStudentGender());
            }

            if (Objects.nonNull(student.getStudentClass()) && !"".equalsIgnoreCase(student.getStudentClass())) {
                stud.setStudentClass(student.getStudentClass());
            }

            return studentRepository.save(stud);

        }

        return null;
    }

    @Override
    public Boolean deleteStudent(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
