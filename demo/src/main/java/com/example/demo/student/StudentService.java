package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //con esto la convierto en un Bean gestionado por Spring (un objeto vaya)
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();//devuelve una lista de todos
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) throw new IllegalStateException("Student already exists");
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId))
            throw new IllegalStateException("Student does not exist with the given id--> " + studentId);
        studentRepository.deleteById(studentId);
    }

    @Transactional//hace que no tengamos que usar una query
    public void uppdateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalStateException("Student does not exist with the given id--> " + studentId));

        if (name != null && !name.isEmpty() && !Objects.equals(student.getName(), name))
            student.setName(name);

        if (email != null && !email.isEmpty() && !Objects.equals(student.getName(), email)) {//no es el mismo nombre el anterior que habia al que quiere poner ahora
            student.setEmail(email);
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if (studentOptional.isPresent() && !studentOptional.get().getId().equals(studentId)) {
                throw new IllegalStateException("Student already exists with the given email--> " + email);
            }
            student.setEmail(email);
        }
    }
}
