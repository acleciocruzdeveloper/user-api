package br.com.backend.customers.config;

import br.com.backend.customers.domain.Customers;
import br.com.backend.customers.domain.dto.CustomersDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CustomersDTO, Customers>() {
            @Override
            protected void configure() {
                map().getEndereco().setLogradouro(source.getEndereco().getLogradouro());
                map().getEndereco().setNumero(source.getEndereco().getNumero());
                map().getEndereco().setBairro(source.getEndereco().getBairro());
                map().getEndereco().setEstado(source.getEndereco().getEstado());
                map().getEndereco().setCidade(source.getEndereco().getCidade());
                map().getEndereco().setUf(source.getEndereco().getUf());
            }
        });
        return modelMapper;
    }
}
