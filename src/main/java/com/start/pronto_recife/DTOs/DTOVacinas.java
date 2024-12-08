package com.start.pronto_recife.DTOs;



import java.time.LocalDate;

public record DTOVacinas(String pacienteId,
                         String nomeVacina,
                         LocalDate dataAplicacao,
                         LocalDate proximaDose
                         ) {

}
