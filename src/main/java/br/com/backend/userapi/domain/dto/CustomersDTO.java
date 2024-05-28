package br.com.backend.userapi.domain.dto;

import java.util.Date;

public record CustomersDTO(
        String nome,
        String cpf,
        String endereco,
        String email,
        String telefone,
        Date dataCadastro
) {
}
