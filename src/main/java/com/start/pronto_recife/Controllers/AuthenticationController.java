package com.start.pronto_recife.Controllers;


import com.start.pronto_recife.DTOs.Auth.AuthenticationRequestDTO;
import com.start.pronto_recife.DTOs.Auth.AuthenticationResponseDTO;
import com.start.pronto_recife.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthenticationResponseDTO login(@RequestBody AuthenticationRequestDTO request){
        String token = authenticationService.authenticate(request);
        return new AuthenticationResponseDTO(token);
    }
}
