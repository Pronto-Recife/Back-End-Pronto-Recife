package com.start.pronto_recife.Exceptions.User;

import com.start.pronto_recife.Exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class UserAuthenticationException extends BaseException {

    //Mensagem de erro da Tela de login: Dados incorretos
    public UserAuthenticationException() {
        super(HttpStatus.UNAUTHORIZED,
                "Dados incorretos",
                "Senha ou login incorretos!");
    }
}
