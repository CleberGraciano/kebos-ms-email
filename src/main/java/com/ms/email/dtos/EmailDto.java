package com.ms.email.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {

    @NotBlank
    @Email
    private String destinatario;
    @NotBlank
    private String assunto;
    @NotBlank
    private String mensagem;

}
