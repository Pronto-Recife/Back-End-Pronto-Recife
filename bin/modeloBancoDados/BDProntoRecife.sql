-- Configurações Iniciais
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `prontorecife` DEFAULT CHARACTER SET utf8;
USE `prontorecife`;

CREATE TABLE IF NOT EXISTS `Estabelecimento` (
  id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
  nome VARCHAR(255) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  email VARCHAR(255) NOT NULL,
  id_medico BINARY(16),
  id_paciente BINARY(16),
  id_consulta BINARY(16),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_estabelecimento_consulta`
    FOREIGN KEY (`id_consulta`)
    REFERENCES `consulta` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estabelecimento_medico`
    FOREIGN KEY (`id_medico`)
    REFERENCES `medico` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estabelecimento_paciente`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `paciente` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `responsavel` (
  id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
  nome_completo VARCHAR(100) NOT NULL,
  grau_parentesco VARCHAR(45) NOT NULL,
  data_nascimento DATE NOT NULL,
  genero VARCHAR(10) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  email VARCHAR(50),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Paciente
CREATE TABLE IF NOT EXISTS `paciente` (
  id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
  nome_completo VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  data_nascimento DATE NOT NULL,
  genero VARCHAR(10) NOT NULL,
  email VARCHAR(100),
  telefone VARCHAR(15) NOT NULL,
  contato_representante VARCHAR(15),
  cep VARCHAR(9) NOT NULL,
  endereco VARCHAR(250) NOT NULL,
  responsavel_id BINARY(16),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_paciente_responsavel`
    FOREIGN KEY (`responsavel_id`)
    REFERENCES `responsavel` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Médico
CREATE TABLE IF NOT EXISTS `medico` (
  id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
  crm VARCHAR(15) NOT NULL,
  email VARCHAR(100) NOT NULL,
  nome_completo VARCHAR(100) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `crm_UNIQUE` (`crm` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Laudos
CREATE TABLE IF NOT EXISTS `laudos` (
  id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
  descricao TEXT,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Consulta
CREATE TABLE IF NOT EXISTS `consulta` (
  id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
  data_consulta DATE NOT NULL,
  tratamentos_prescritos TEXT NOT NULL,
  instrucoes_recomendacoes TEXT NOT NULL,
  sintomas TEXT NOT NULL,
  historico_familiar VARCHAR(255),
  paciente_id BINARY(16) NOT NULL,
  medico_id BINARY(16) NOT NULL,
  laudos_id BINARY(16),
  PRIMARY KEY (`id`),
    CONSTRAINT `fk_consulta_paciente`
        FOREIGN KEY (`paciente_id`)
        REFERENCES `paciente` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_consulta_medico`
        FOREIGN KEY (`medico_id`)
        REFERENCES `medico` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_consulta_laudos`
        FOREIGN KEY (`laudos_id`)
        REFERENCES `laudos` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Exame do Paciente
CREATE TABLE IF NOT EXISTS `exame_do_paciente` (
  id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
  data_exame DATE NOT NULL,
  resultado TEXT NOT NULL,
  nome_do_exame VARCHAR(100) NOT NULL,
  paciente_id BINARY(16) NOT NULL,
  consulta_id BINARY(16),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_exame_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `paciente` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_exame_consulta`
    FOREIGN KEY (`consulta_id`)
    REFERENCES `consulta` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Histórico Médico
CREATE TABLE IF NOT EXISTS `historico_medico` (
  id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
  cirurgias_anteriores TEXT,
  condicoes_gerais VARCHAR(255),
  paciente_id BINARY(16) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_historico_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `paciente` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Configurações Finais
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
