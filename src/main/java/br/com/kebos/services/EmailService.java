package br.com.kebos.services;

import br.com.kebos.enums.StatusEmail;
import br.com.kebos.models.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class EmailService {


    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;


    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setDataEnvioEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(emailModel.getDestinatario());
            message.setSubject(emailModel.getAssunto());
            message.setText(emailModel.getMensagem());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);

        } finally {
            return emailModel;
        }
    }

}
