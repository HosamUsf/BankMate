package com.dev.BankMate.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String userRole;

    @NotEmpty
    @Size(min = 11,max = 11)
    private String mobileNumber ;

    @NotEmpty
    private LocalDateTime createdAt = LocalDateTime.now();

    private Boolean locked = false;

    private Boolean enabled = false;


    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.email = user.email;
        this.password =user.password;
        this.userRole = user.userRole;
        this.mobileNumber=user.getMobileNumber();
        this.createdAt=user.getCreatedAt();
        this.locked = user.locked;
        this.enabled = user.enabled;
    }


    public User(String username, String email, String password,String mobileNumber, String userRole) {
        this.username=username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.userRole = userRole;

    }
}
