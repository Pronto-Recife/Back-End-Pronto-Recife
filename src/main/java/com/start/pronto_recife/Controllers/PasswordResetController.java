package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.PasswordResetTokenDTO;
import com.start.pronto_recife.Service.PasswordResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/password-reset")
@RequiredArgsConstructor
public class PasswordResetController {

    private final PasswordResetService passwordResetService;

    @PostMapping("/generate-token")
    @ResponseStatus(HttpStatus.CREATED)
    public PasswordResetTokenDTO generateToken(@RequestParam String email) {
        return passwordResetService.generateToken(email);
    }

    @PostMapping("/validate-token")
    public boolean validateToken(@RequestParam String token) {
        return passwordResetService.validateToken(token);
    }

    @PutMapping("/reset-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        passwordResetService.resetPassword(token, newPassword);
    }
}
