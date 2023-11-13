package com.dev.BankMate.contacts;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = )
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;

    @NotEmpty
    private String contactName;

    @NotEmpty
    private String contactEmail;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String message;

    @NotEmpty
    private LocalDateTime createAt;


}
