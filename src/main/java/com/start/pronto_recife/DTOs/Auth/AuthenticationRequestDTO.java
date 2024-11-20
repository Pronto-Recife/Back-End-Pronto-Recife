package com.start.pronto_recife.DTOs.Auth;

import com.start.pronto_recife.Enum.LoginFlowEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestDTO {
    private String identificador;
    private String senha;
    private LoginFlowEnum flow;

}
