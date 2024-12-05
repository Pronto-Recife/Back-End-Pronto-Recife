CREATE SCHEMA IF NOT EXISTS `prontorecife` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `prontorecife` ;

-- -----------------------------------------------------
-- Table `prontorecife`.`agente_saude`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`agente_saude` (
      `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `nome` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `senha` VARCHAR(255) NOT NULL,
    `cpf` VARCHAR(14) NOT NULL,
    `telefone` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email` (`email` ASC),
    UNIQUE INDEX `cpf` (`cpf` ASC))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `prontorecife`.`laudos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`laudos` (
    `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `descricao` TEXT NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `prontorecife`.`responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS responsavel (
    id CHAR(36) DEFAULT (UUID()),
    nome_completo VARCHAR(100)  NULL,
    grau_parentesco VARCHAR(45) NULL,
    endereco VARCHAR(255) NULL,
    telefone VARCHAR(15) NULL,
    email VARCHAR(50) UNIQUE NULL,
    cpf VARCHAR(14) UNIQUE NULL,
    data_nascimento DATE NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX email_UNIQUE (email ASC),
    UNIQUE INDEX idx_cpf (cpf)
    ) ENGINE = InnoDB DEFAULT CHARSET=utf8;
-- -----------------------------------------------------
-- Table `prontorecife`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`paciente` (
    `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `nome_completo` VARCHAR(100) NOT NULL,
    `estado_civil` VARCHAR(50) NULL DEFAULT NULL,
    `cpf` VARCHAR(14) NOT NULL,
    `data_nascimento` DATE NULL DEFAULT NULL,
    `genero` VARCHAR(10) NULL DEFAULT NULL,
    `email` VARCHAR(100) NOT NULL,
    `senha` VARCHAR(255) NOT NULL,
    `telefone` VARCHAR(15) NULL DEFAULT NULL,
    `contato_representante` VARCHAR(15) NULL DEFAULT NULL,
    `endereco` VARCHAR(255) NULL DEFAULT NULL,
    `responsavel_cpf` VARCHAR(14) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `cpf` (`cpf` ASC),
    UNIQUE INDEX `email` (`email` ASC),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC),
    INDEX `fk_paciente_responsavel` (`responsavel_cpf` ASC),
    CONSTRAINT `fk_paciente_responsavel`
    FOREIGN KEY (`responsavel_cpf`)
    REFERENCES `prontorecife`.`responsavel` (`cpf`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Table `prontorecife`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`medico` (
    `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `crm` VARCHAR(15) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `senha` VARCHAR(255) NOT NULL,
    `nome_completo` VARCHAR(100) NOT NULL,
    `telefone` VARCHAR(15) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `crm` (`crm` ASC),
    UNIQUE INDEX `email` (`email` ASC),
    UNIQUE INDEX `crm_UNIQUE` (`crm` ASC),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `prontorecife`.`consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`consulta` (
    `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `data_consulta` DATE NOT NULL,
    `tratamentos_prescritos` TEXT NOT NULL,
    `instrucoes_recomendacoes` TEXT NOT NULL,
    `sintomas` TEXT NOT NULL,
    `historico_familiar` VARCHAR(255) NULL DEFAULT NULL,
    `paciente_id` CHAR(36) NOT NULL,
    `laudos_id` CHAR(36) NULL DEFAULT NULL,
    `medico_id` CHAR(36) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_consulta_paciente` (`paciente_id` ASC),
    INDEX `fk_consulta_laudos` (`laudos_id` ASC),
    INDEX `fk_consulta_medico1_idx` (`medico_id` ASC),
    CONSTRAINT `fk_consulta_laudos`
    FOREIGN KEY (`laudos_id`)
    REFERENCES `prontorecife`.`laudos` (`id`),
    CONSTRAINT `fk_consulta_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `prontorecife`.`paciente` (`id`),
    CONSTRAINT `fk_consulta_medico1`
    FOREIGN KEY (`medico_id`)
    REFERENCES `prontorecife`.`medico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `prontorecife`.`estabelecimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`estabelecimento` (
    `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `cnpj` VARCHAR(18) NOT NULL,
    `nome` VARCHAR(255) NOT NULL,
    `endereco` VARCHAR(255) NULL DEFAULT NULL,
    `telefone` VARCHAR(15) NULL DEFAULT NULL,
    `email` VARCHAR(255) NOT NULL,
    `senha` VARCHAR(255) NOT NULL,
    `id_medico` CHAR(36) NULL DEFAULT NULL,
    `id_consulta` CHAR(36) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `cnpj` (`cnpj` ASC),
    UNIQUE INDEX `email` (`email` ASC),
    UNIQUE INDEX `idx_id` (`id` ASC))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `prontorecife`.`exame_do_paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`exame_do_paciente` (
    `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `data_exame` DATE NOT NULL,
    `resultado` TEXT NOT NULL,
    `nome_do_exame` VARCHAR(100) NOT NULL,
    `paciente_cpf` VARCHAR(14) NOT NULL,
    `consulta_id` CHAR(36) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `paciente_cpf` (`paciente_cpf` ASC),
    INDEX `fk_exame_consulta` (`consulta_id` ASC),
    CONSTRAINT `fk_exame_consulta`
    FOREIGN KEY (`consulta_id`)
    REFERENCES `prontorecife`.`consulta` (`id`),
    CONSTRAINT `fk_exame_paciente`
    FOREIGN KEY (`paciente_cpf`)
    REFERENCES `prontorecife`.`paciente` (`cpf`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `prontorecife`.`flyway_schema_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`flyway_schema_history` (
    `installed_rank` INT NOT NULL,
    `version` VARCHAR(50) NULL DEFAULT NULL,
    `description` VARCHAR(200) NOT NULL,
    `type` VARCHAR(20) NOT NULL,
    `script` VARCHAR(1000) NOT NULL,
    `checksum` INT NULL DEFAULT NULL,
    `installed_by` VARCHAR(100) NOT NULL,
    `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `execution_time` INT NOT NULL,
    `success` TINYINT(1) NOT NULL,
    PRIMARY KEY (`installed_rank`),
    INDEX `flyway_schema_history_s_idx` (`success` ASC))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `prontorecife`.`historico_medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`historico_medico` (
    `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `cirurgias_anteriores` TEXT NULL DEFAULT NULL,
    `condicoes_gerais` VARCHAR(255) NULL DEFAULT NULL,
    `paciente_id` CHAR(36) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_historico_paciente` (`paciente_id` ASC),
    CONSTRAINT `fk_historico_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `prontorecife`.`paciente` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `prontorecife`.`password_reset_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`password_reset_token` (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `token` VARCHAR(6) NOT NULL,
    `expiration` DATETIME NOT NULL,
    `medico_id` CHAR(36) NULL DEFAULT NULL,
    `paciente_id` CHAR(36) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_password_reset_medico` (`medico_id` ASC),
    INDEX `fk_password_reset_paciente` (`paciente_id` ASC),
    CONSTRAINT `fk_password_reset_medico`
    FOREIGN KEY (`medico_id`)
    REFERENCES `prontorecife`.`medico` (`id`)
    ON DELETE CASCADE,
    CONSTRAINT `fk_password_reset_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `prontorecife`.`paciente` (`id`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `prontorecife`.`password_reset_token_seq`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`password_reset_token_seq` (
 `next_not_cached_value` BIGINT NOT NULL,
 `minimum_value` BIGINT NOT NULL,
 `maximum_value` BIGINT NOT NULL,
 `start_value` BIGINT NOT NULL,
 `increment` BIGINT NOT NULL,
 `cache_size` BIGINT NOT NULL,
 `cycle_option` TINYINT(1) NOT NULL,
    `cycle_count` BIGINT NOT NULL)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `prontorecife`.`profissional_saude`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`profissional_saude` (
    `id` CHAR(36) NOT NULL DEFAULT uuid(),
    `nome` VARCHAR(255) NOT NULL,
    `coren` VARCHAR(15) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `senha` VARCHAR(255) NOT NULL,
    `telefone` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `coren` (`coren` ASC),
    UNIQUE INDEX `email` (`email` ASC))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `prontorecife`.`estabelecimentoParaMedicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`estabelecimentoParaMedicos` (
     `estabelecimento_id` CHAR(36) NOT NULL,
    `medico_id` CHAR(36) NOT NULL,
    PRIMARY KEY (`estabelecimento_id`, `medico_id`),
    INDEX `fk_estabelecimento_has_medico_medico1_idx` (`medico_id` ASC),
    INDEX `fk_estabelecimento_has_medico_estabelecimento1_idx` (`estabelecimento_id` ASC),
    CONSTRAINT `fk_estabelecimento_has_medico_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `prontorecife`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_estabelecimento_has_medico_medico1`
    FOREIGN KEY (`medico_id`)
    REFERENCES `prontorecife`.`medico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `prontorecife`.`estabelecimentoParaProfissionais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`estabelecimentoParaProfissionais` (
      `estabelecimento_id` CHAR(36) NOT NULL,
    `profissional_saude_id` CHAR(36) NOT NULL,
    PRIMARY KEY (`estabelecimento_id`, `profissional_saude_id`),
    INDEX `fk_estabelecimento_has_profissional_saude_profissional_saud_idx` (`profissional_saude_id` ASC),
    INDEX `fk_estabelecimento_has_profissional_saude_estabelecimento1_idx` (`estabelecimento_id` ASC),
    CONSTRAINT `fk_estabelecimento_has_profissional_saude_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `prontorecife`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_estabelecimento_has_profissional_saude_profissional_saude1`
    FOREIGN KEY (`profissional_saude_id`)
    REFERENCES `prontorecife`.`profissional_saude` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Table `prontorecife`.`estabelecimentoParaAgente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prontorecife`.`estabelecimentoParaAgente` (
    `estabelecimento_id` CHAR(36) NOT NULL,
    `agente_saude_id` CHAR(36) NOT NULL,
    PRIMARY KEY (`estabelecimento_id`, `agente_saude_id`),
    INDEX `fk_estabelecimento_has_agente_saude_agente_saude1_idx` (`agente_saude_id` ASC),
    INDEX `fk_estabelecimento_has_agente_saude_estabelecimento1_idx` (`estabelecimento_id` ASC),
    CONSTRAINT `fk_estabelecimento_has_agente_saude_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `prontorecife`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_estabelecimento_has_agente_saude_agente_saude1`
    FOREIGN KEY (`agente_saude_id`)
    REFERENCES `prontorecife`.`agente_saude` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;