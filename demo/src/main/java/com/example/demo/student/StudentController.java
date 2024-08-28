package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController//esta clase sera un controlador para manejar solicitudes REST(devolver datos en json)
@RequestMapping(path = "api/v1/student")//ruta que será manejada por esta clase (los get,post...)
public class StudentController {
    //recursos para nuestra API

    //dependencia
    private final StudentService studentService;

    @Autowired// le indica a Spring que debe inyectar una instancia de StudentService cuando cree un StudentController
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //solicitudes get
    @GetMapping//obtener estudiantes
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //solicitudes post
    @PostMapping//añadir
    public  void addStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //solicitudes delete
    @DeleteMapping(path="{studentId}")
    public  void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    //solicitudes actualizaciones
    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.uppdateStudent(studentId,name,email);

    }

}
