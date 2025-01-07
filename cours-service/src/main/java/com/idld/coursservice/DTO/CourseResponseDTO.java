package com.idld.coursservice.DTO;


import com.idld.coursservice.modele.Teacher;
import jakarta.persistence.Transient;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {
    private Long id;
    private String title;
    private String description;
    private int credit;

    private long TeacherId;

    @Transient
    private TeacherDtoResponse teacher;

}
