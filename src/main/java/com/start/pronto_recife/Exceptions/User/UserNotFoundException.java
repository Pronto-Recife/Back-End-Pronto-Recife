package com.start.pronto_recife.Exceptions.User;

import com.start.pronto_recife.Exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {
    //Para o metodo update: Id não encontrado
    public UserNotFoundException(String id){
        super(HttpStatus.NOT_FOUND, "Id não encontrado."
                , "Não foi possivel encontrar o usuário com o id: "+ id + ".");
    }
    //Para tela de login, FindAll, Delete: Usuário não encontrado
    public UserNotFoundException(String identificador, String flow) {
        super(HttpStatus.NOT_FOUND, "Usuário não encontrado.",
                "Não foi possivel encontrar o " + flow + " do usuário: " + identificador + ".");
    }

}
