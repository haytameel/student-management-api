package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository//es responsable del acceso a los datos
public interface StudentRepository extends JpaRepository<Student, Long> {

    //consulta JPQL
    @Query("SELECT st FROM Student st WHERE st.email = ?1")//lo mismo que decir @Query(value = "SELECT * FROM student WHERE email = ?1", nativeQuery = true)
    Optional<Student> findByEmail(String email);

}
