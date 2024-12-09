CREATE SCHEMA IF NOT EXISTS `prontorecife` DEFAULT CHARACTER SET utf8;
USE `prontorecife`;

-- Tabela Laudos
CREATE TABLE `laudos` (
  id CHAR(36) DEFAULT (UUID()),
  descricao TEXT,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Responsável
CREATE TABLE IF NOT EXISTS `responsavel` (
  id CHAR(36) DEFAULT (UUID()),
  nome_completo VARCHAR(100) NOT NULL,
  grau_parentesco VARCHAR(45) NOT NULL,
  data_nascimento DATE NOT NULL,
  genero VARCHAR(10) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  email VARCHAR(50) UNIQUE,
  cpf VARCHAR(14) UNIQUE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `idx_cpf` (`cpf`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- Tabela Médico
CREATE TABLE `medico` (
  id CHAR(36) DEFAULT (UUID()),
  crm VARCHAR(15) UNIQUE NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL,
  nome_completo VARCHAR(100) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `crm_UNIQUE` (`crm` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


-- Tabela Agente de Saúde
CREATE TABLE IF NOT EXISTS agente_saude (
  id CHAR(36) DEFAULT (UUID()),
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  senha VARCHAR(255) NOT NULL,
  telefone VARCHAR(255) NOT NULL,
  cpf VARCHAR(14) UNIQUE NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- Tabela Profissional de Saúde
CREATE TABLE IF NOT EXISTS profissional_saude (
  id CHAR(36) DEFAULT (UUID()),
  nome VARCHAR(255) NOT NULL,
  coren VARCHAR(15) UNIQUE NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL,
  telefone VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- Tabela Paciente
CREATE TABLE IF NOT EXISTS `paciente` (
  id CHAR(36) DEFAULT (UUID()),                             -- id será gerado automaticamente no prePersist
  nome_completo VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) UNIQUE NOT NULL,
  data_nascimento DATE NOT NULL,
  genero VARCHAR(10) NOT NULL,
  email VARCHAR(100) UNIQUE,
  senha VARCHAR(255) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  contato_representante VARCHAR(15),
  endereco VARCHAR(250) NOT NULL,
  alergia VARCHAR(255),                                      -- Alergia
  condicoes_cronicas VARCHAR(255),                            -- Condições crônicas
  responsavel_cpf VARCHAR(14),                               -- Responsável CPF
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
  data_consulta DATETIME NOT NULL,
  tratamentos_prescritos TEXT NOT NULL,
  instrucoes_recomendacoes TEXT NOT NULL,
  sintomas TEXT NOT NULL,
  historico_familiar VARCHAR(255),
  condicoes_gerais VARCHAR(255),
  diagnostico VARCHAR(255),
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



-- Tabelas de Reset de Senha
CREATE TABLE password_reset_token (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    token VARCHAR(6) NOT NULL,
    expiration DATETIME NOT NULL,
    id_medico CHAR(36),
    id_paciente CHAR(36),
    CONSTRAINT fk_password_reset_medico FOREIGN KEY (id_medico)
        REFERENCES medico (id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT fk_password_reset_paciente FOREIGN KEY (id_paciente)
        REFERENCES paciente (id) ON DELETE CASCADE ON UPDATE NO ACTION
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