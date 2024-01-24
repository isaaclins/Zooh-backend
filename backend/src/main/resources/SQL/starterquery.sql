-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema zooh
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `zooh` ;

-- -----------------------------------------------------
-- Schema zooh
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zooh` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema zooh
-- -----------------------------------------------------
USE `zooh` ;

-- -----------------------------------------------------
-- Table `zooh`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`user` (
                                             `userid` INT NOT NULL,
                                             `username` VARCHAR(255) NOT NULL,
                                             `password` VARCHAR(255) NOT NULL,
                                             PRIMARY KEY (`userid`),
                                             UNIQUE INDEX `userid_UNIQUE` (`userid` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zooh`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`ticket` (
                                               `ticketid` INT NOT NULL,
                                               `used` TINYINT NOT NULL DEFAULT 0,
                                               `cost` DECIMAL(2) NOT NULL,
                                               `userid` INT NOT NULL,
                                               `expirationdate` DATE NOT NULL,
                                               PRIMARY KEY (`ticketid`),
                                               UNIQUE INDEX `ID_UNIQUE` (`ticketid` ASC) VISIBLE,
                                               INDEX `ticketidtouserid_idx` (`userid` ASC) VISIBLE,
                                               CONSTRAINT `ticketidtouserid`
                                                   FOREIGN KEY (`userid`)
                                                       REFERENCES `zooh`.`user` (`userid`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
