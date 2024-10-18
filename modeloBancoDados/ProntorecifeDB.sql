SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `prontorecife` DEFAULT CHARACTER SET utf8 ;
USE `prontorecife` ;


CREATE TABLE IF NOT EXISTS `prontorecife`.`responsavel` (
  `CPF` VARCHAR(14) NOT NULL,
  `nome_completo` VARCHAR(30) NOT NULL,
  `grau_parenteso` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `gênero` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(15) NULL DEFAULT NULL,
  `email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`CPF`),
  UNIQUE INDEX `id_dependente_UNIQUE` (`CPF` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `prontorecife`.`paciente` (
  `CPF` VARCHAR(14) NOT NULL DEFAULT '000.000.000-00',
  `nome_completo` VARCHAR(100) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `gênero` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL DEFAULT 'exemplo@exemplo.com',
  `telefone` VARCHAR(15) NULL DEFAULT '(00)00000-0000',
  `contato_representante` VARCHAR(15) NULL DEFAULT '(00)00000-0000',
  `cep` VARCHAR(9) NULL DEFAULT NULL,
  `endereco` VARCHAR(250) NULL DEFAULT NULL,
  `responsavel_CPF` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`CPF`),
  UNIQUE INDEX `id_paciente_UNIQUE` (`CPF` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_paciente_responsavel1_idx` (`responsavel_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_paciente_responsavel1`
    FOREIGN KEY (`responsavel_CPF`)
    REFERENCES `prontorecife`.`responsavel` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `prontorecife`.`medico` (
  `CRM` VARCHAR(10) NOT NULL,
  `nome_completo` VARCHAR(100) NOT NULL,
  `especialidade` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(15) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`CRM`),
  UNIQUE INDEX `id_medico_UNIQUE` (`CRM` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `prontorecife`.`laudos` (
  `ID` INT(11) NOT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `prontorecife`.`consulta` (
  `ID` INT(5) NOT NULL,
  `data_consulta` DATE NOT NULL,
  `tratamentos_prescritos` TEXT NOT NULL,
  `instrucoes_recomendacoes` TEXT NOT NULL,
  `sintomas` TEXT NOT NULL,
  `historico_familiar` VARCHAR(45) NULL,
  `paciente_CPF` VARCHAR(14) NOT NULL,
  `medico_CRM` VARCHAR(10) NOT NULL,
  `laudos_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_consulta_paciente1_idx` (`paciente_CPF` ASC) VISIBLE,
  INDEX `fk_consulta_medico1_idx` (`medico_CRM` ASC) VISIBLE,
  INDEX `fk_consulta_laudos1_idx` (`laudos_ID` ASC) VISIBLE,
  CONSTRAINT `fk_consulta_paciente1`
    FOREIGN KEY (`paciente_CPF`)
    REFERENCES `prontorecife`.`paciente` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_medico1`
    FOREIGN KEY (`medico_CRM`)
    REFERENCES `prontorecife`.`medico` (`CRM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_laudos1`
    FOREIGN KEY (`laudos_ID`)
    REFERENCES `prontorecife`.`laudos` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `prontorecife`.`exame do paciente` (
  `id_exames` INT(11) NOT NULL AUTO_INCREMENT,
  `data_exame` DATE NOT NULL,
  `resultado` TEXT NOT NULL,
  `Nome do exame_id` INT NOT NULL,
  `paciente_CPF` VARCHAR(14) NOT NULL,
  `consulta_ID` INT(5) NOT NULL,
  PRIMARY KEY (`id_exames`),
  INDEX `fk_exame do paciente_paciente1_idx` (`paciente_CPF` ASC) VISIBLE,
  INDEX `fk_exame do paciente_consulta1_idx` (`consulta_ID` ASC) VISIBLE,
  CONSTRAINT `fk_exame do paciente_paciente1`
    FOREIGN KEY (`paciente_CPF`)
    REFERENCES `prontorecife`.`paciente` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exame do paciente_consulta1`
    FOREIGN KEY (`consulta_ID`)
    REFERENCES `prontorecife`.`consulta` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `prontorecife`.`historico_medico` (
  `ID` INT(10) NOT NULL,
  `cirurgias_anteriores` TEXT NULL DEFAULT NULL,
  `codicoes_gerais` VARCHAR(45) NULL,
  `paciente_CPF` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_historico_medico_paciente1_idx` (`paciente_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_historico_medico_paciente1`
    FOREIGN KEY (`paciente_CPF`)
    REFERENCES `prontorecife`.`paciente` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
