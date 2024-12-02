package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.PasswordResetTokenDTO;
import com.start.pronto_recife.Models.PasswordResetToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PasswordResetTokenMapper {
    PasswordResetTokenDTO toDTO(PasswordResetToken passwordResetToken);
}
