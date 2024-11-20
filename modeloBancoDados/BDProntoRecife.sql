CREATE SCHEMA IF NOT EXISTS `prontorecife` DEFAULT CHARACTER SET utf8;
USE `prontorecife`;

-- Tabela Laudos
CREATE TABLE `laudos` (
  id CHAR(36) DEFAULT (UUID()),
  descricao TEXT,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Médico
CREATE TABLE `medico` (
  id CHAR(36) DEFAULT (UUID()),
  crm VARCHAR(15) NOT NULL,
  especialidade VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  nome_completo VARCHAR(100) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `crm_UNIQUE` (`crm` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Responsável
-- Tabela Responsável
CREATE TABLE IF NOT EXISTS `responsavel` (
  id CHAR(36) DEFAULT (UUID()),
  nome_completo VARCHAR(100) NOT NULL,
  grau_parentesco VARCHAR(45) NOT NULL,
  data_nascimento DATE NOT NULL,
  genero VARCHAR(10) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  email VARCHAR(50),
  cpf VARCHAR(14) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `idx_cpf` (`cpf`) -- Índice adicionado para o campo cpf
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Paciente
CREATE TABLE IF NOT EXISTS `paciente` (
  id CHAR(36) DEFAULT (UUID()),
  nome_completo VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  data_nascimento DATE NOT NULL,
  genero VARCHAR(10) NOT NULL,
  email VARCHAR(100),
  senha VARCHAR(255) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  contato_representante VARCHAR(15),
  cep VARCHAR(9) NOT NULL,
  endereco VARCHAR(250) NOT NULL,
  responsavel_cpf VARCHAR(14),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_paciente_responsavel`
    FOREIGN KEY (`responsavel_cpf`)
    REFERENCES `responsavel` (`cpf`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Consulta
CREATE TABLE `consulta` (
  id CHAR(36) DEFAULT (UUID()),
  data_consulta DATE NOT NULL,
  tratamentos_prescritos TEXT NOT NULL,
  instrucoes_recomendacoes TEXT NOT NULL,
  sintomas TEXT NOT NULL,
  historico_familiar VARCHAR(255),
  paciente_id CHAR(36) NOT NULL,
  medico_id CHAR(36) NOT NULL,
  laudos_id CHAR(36),
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

-- Tabela Estabelecimento
CREATE TABLE `estabelecimento` (
  id CHAR(36) DEFAULT (UUID()),
  cnpj VARCHAR(18) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  id_medico CHAR(36),
  id_paciente CHAR(36),
  id_consulta CHAR(36),
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

-- Tabela Exame do Paciente
CREATE TABLE IF NOT EXISTS `exame_do_paciente` (
  id CHAR(36) DEFAULT (UUID()),
  data_exame DATE NOT NULL,
  resultado TEXT NOT NULL,
  nome_do_exame VARCHAR(100) NOT NULL,
  paciente_id CHAR(36) NOT NULL,
  consulta_id CHAR(36),
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
  id CHAR(36) DEFAULT (UUID()),
  cirurgias_anteriores TEXT,
  condicoes_gerais VARCHAR(255),
  paciente_id CHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_historico_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `paciente` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;
