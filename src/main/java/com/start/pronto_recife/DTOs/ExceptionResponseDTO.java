package com.start.pronto_recife.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ExceptionResponseDTO {
    String message;
    Map<String, String> erros;
}