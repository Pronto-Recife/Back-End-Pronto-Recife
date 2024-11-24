package com.start.pronto_recife.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Schema(description = "DTO para token de recuperação de senha")
public record PasswordResetTokenDTO(

        @Schema(description = "Token de 6 dígitos para recuperação de senha", example = "123456")
        @NotBlank
        @Pattern(regexp = "\\d{6}", message = "O token deve conter exatamente 6 números")
        String token,

        @Schema(description = "Data e hora de expiração do token", example = "2024-11-23T12:30:00")
        @NotNull
        LocalDateTime expiration

) {

}
