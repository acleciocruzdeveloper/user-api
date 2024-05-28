package br.com.backend.userapi.domain.dto;

import br.com.backend.userapi.enums.EUnidadesFederativas;

public record AddressDTO(
        long id,
        String logradouro,
        int numero,
        String bairro,
        String cidade,
        EUnidadesFederativas uf,
        String estado
) {
}
