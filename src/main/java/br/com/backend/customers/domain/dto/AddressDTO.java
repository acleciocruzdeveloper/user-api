package br.com.backend.customers.domain.dto;

import br.com.backend.customers.enums.EUnidadesFederativas;
import lombok.Data;

@Data
public class AddressDTO {
    private long id;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private EUnidadesFederativas uf;
    private String estado;

}
