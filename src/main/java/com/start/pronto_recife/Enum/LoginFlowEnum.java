package com.start.pronto_recife.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LoginFlowEnum {
        CRM,
        CPF,
        COREN;

        @JsonValue
        @Override
        public String toString() {
                return name();
        }

        @JsonCreator
        public static LoginFlowEnum fromValue(String value) {
                return LoginFlowEnum.valueOf(value.toUpperCase());
        }
}