package br.com.backend.userapi.domain.dto;

import lombok.Data;

import java.util.Date;
@Data
public class CustomersDTO{
        private Long id;
        private String nome;
        private String cpf;
        private AddressDTO endereco;
        private String email;
        private String password;
        private String telefone;
        private Date dataCadastro;
}
