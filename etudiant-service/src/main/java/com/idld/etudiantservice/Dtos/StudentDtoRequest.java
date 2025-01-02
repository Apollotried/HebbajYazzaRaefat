package com.idld.etudiantservice.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoRequest {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    private String email;

    private String phone;
    private String address;
}
