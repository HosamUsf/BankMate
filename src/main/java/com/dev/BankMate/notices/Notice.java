package com.dev.BankMate.notices;


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
@Table(name = "notices_details")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticesId;

    @NotEmpty
    private String noticeSummary;

    @NotEmpty
    private String noticeDetails;

    @NotEmpty
    private LocalDateTime noticeBeginDate;

    @NotEmpty
    private LocalDateTime noticeEndDate;

    @NotEmpty
    private LocalDateTime createAt;

    @NotEmpty
    private LocalDateTime updatedAt;



}
