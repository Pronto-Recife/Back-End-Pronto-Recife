package com.start.pronto_recife.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class EmailService{
    
        private final JavaMailSender javaMailSender;

        public void sendEmail(String to, String token, String expiration){
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("noreply@gmail.com");
                message.setTo(to);
                message.setSubject("Redefinição de Senha");
                message.setText("Utilize o codigo token abaixo para redefinir sua senha!" +
                        "\n\nToken: " + token + "\nData de Validade: " + expiration);
                javaMailSender.send(message);
        }
}