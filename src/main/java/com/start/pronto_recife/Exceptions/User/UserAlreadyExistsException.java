package com.start.pronto_recife.Exceptions.User;

import com.start.pronto_recife.Exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BaseException {

//Mensagem de erro para o cadastro: Usuário ja cadastrado
    public UserAlreadyExistsException(String identificador, String flow) {
        super(HttpStatus.CONFLICT,
                "Usuário já cadastrado",
                "O " + flow + ": " + identificador + " já está cadastrado no sistema");
    }
}
