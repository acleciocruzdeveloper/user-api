package br.com.backend.userapi.domain.dto;

import br.com.backend.userapi.enums.EUnidadesFederativas;
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
