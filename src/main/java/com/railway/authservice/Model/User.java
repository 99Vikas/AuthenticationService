package com.railway.authservice.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document("customers")
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private String mobileNumber;
    private String password;
    private String role;
}