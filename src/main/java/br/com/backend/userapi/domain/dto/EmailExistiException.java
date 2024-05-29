package br.com.backend.userapi.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmailExistiException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;
    private final List<FieldErrors> fields;

    public EmailExistiException(HttpStatus httpStatus, String message, List<FieldErrors> fields) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
        this.fields = fields;
    }

    public record FieldErrors(String field) {
    }
}
