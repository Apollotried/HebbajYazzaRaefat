package com.idld.coursservice.DTO;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {
    private String title;
    private String description;
    private int credit;
    private String instructor;
}
