package br.com.backend.customers.domain.dto;

import br.com.backend.customers.enums.ECustomerStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;

@Data
public class CustomersDTO {
    private Long id;
    private String nome;
    private String cpf;
    private AddressDTO endereco;
    private ECustomerStatus statusCustomer;
    private String email;
    private String password;
    private String telefone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Instant dataCadastro;

    public CustomersDTO() {
        this.statusCustomer = ECustomerStatus.ACTIVE;
        this.dataCadastro = Instant.now();
    }
}
