package bo.edu.ucb.sistemagraduados.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDto<T> {
    private String code;
    private T response;
    private String errorMessage;
}