package br.com.kebos.models;

import br.com.kebos.enums.StatusEmail;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID emailId;
    private String destinatario;
    private String assunto;
    private String mensagem;
    private LocalDateTime dataEnvioEmail;
    private StatusEmail statusEmail;
}
