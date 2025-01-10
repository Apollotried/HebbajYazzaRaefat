package com.idld.inscriptionservice.Model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;


}