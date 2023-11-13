package com.dev.BankMate.request;

import jakarta.validation.constraints.NotNull;

public record RegistrationRequest(
        @NotNull
        String username,
        @NotNull
        String email,
        @NotNull
        String password,
        @NotNull
        String role,
        @NotNull
        String mobileNumber

) {
}
