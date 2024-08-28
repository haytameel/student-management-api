package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

//BASICAMENTE CON ESTO CREAMOS LA TABLA DE LA BBDD
@Entity//esta clase sera una entidad JPA que se mapeará a una tabla de BBDD (STUDENT EN ESTE CASO)
@Table//debe mapearse en una tabla
public class Student {
    @Id//clave primaria
    @SequenceGenerator(//generador de secuencias para dicha clave "id"
            name = "student_sequence",//nombre del generadaro
            sequenceName = "student_sequence",//nombre secuencia
            allocationSize = 1//incremento de uno en uno
    )
    @GeneratedValue(//valor de id se generará automáticamente
            strategy = GenerationType.SEQUENCE,//usar una secuencia de uno en uno
            generator = "student_sequence"//nombre del generador
    )
    private Long id;
    private String name;
    private LocalDate birth;
    private String email;
@Transient//que no se almacene como columna en la BBDD
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public Student(String name, String email, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                '}';
    }
}
