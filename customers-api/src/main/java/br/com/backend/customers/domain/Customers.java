package br.com.backend.customers.domain;

import br.com.backend.customers.enums.ECustomerStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customers implements Serializable {
    @Serial
    private static final long serialVersionUID = -8702158702366483093L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco", nullable = false)
    private Address endereco;
    @Enumerated(EnumType.STRING)
    private ECustomerStatus statusCustomer;
    private String email;
    private String password;
    private String telefone;
    @JsonProperty("data_cadastro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Instant dataCadastro;

}
