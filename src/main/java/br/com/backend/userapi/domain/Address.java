package br.com.backend.userapi.domain;

import br.com.backend.userapi.enums.EUnidadesFederativas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 3837374350954274721L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    @Enumerated(value = EnumType.STRING)
    private EUnidadesFederativas uf;
    private String estado;
}
