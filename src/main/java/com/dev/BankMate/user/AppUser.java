package com.dev.BankMate.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")

    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    @JsonProperty("role")
    private String userRole;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String mobileNumber;

    private LocalDateTime createdAt;

    private Boolean locked = false;

    private Boolean enabled = false;


    public AppUser(AppUser appUser) {
        this.id = appUser.id;
        this.name = appUser.name;
        this.email = appUser.email;
        this.password = appUser.password;
        this.userRole = appUser.userRole;
        this.mobileNumber = appUser.getMobileNumber();
        this.createdAt = appUser.getCreatedAt();
        this.locked = appUser.locked;
        this.enabled = appUser.enabled;
    }


    public AppUser(String name, String email, String password, String mobileNumber, String userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.userRole = userRole;

    }
}
