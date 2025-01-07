package com.idld.coursservice.Entity;

import com.idld.coursservice.modele.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre du cours est obligatoire")
    private String title;

    @NotBlank(message = "La description du cours est obligatoire")
    private String description;

    private int credit;
    private String instructor;


    private Long idStudent;
    @Transient
    Student student;

}

