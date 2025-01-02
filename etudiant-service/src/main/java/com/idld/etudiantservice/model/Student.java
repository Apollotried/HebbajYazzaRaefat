package com.idld.etudiantservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    // Relationships
    @Transient // Managed in another microservice
    private List<Long> courseIds;

    @Transient // Managed in another microservice
    private List<Long> resultIds;

}
