-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema zooh
-- -----------------------------------------------------
DROP SCHEMA `zooh`;
CREATE SCHEMA IF NOT EXISTS `zooh` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `zooh` ;

-- -----------------------------------------------------
-- Table `zooh`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`ticket` (
                                               `ticketID` INT NOT NULL AUTO_INCREMENT,
                                               `OwnerName` VARCHAR(255) NOT NULL,
                                               `Used` TINYINT(1) NOT NULL,
                                               `Cost` INT NOT NULL,
                                               `expirationDate` DATE NOT NULL,
                                               PRIMARY KEY (`ticketID`),
                                               UNIQUE INDEX `OwnerName_UNIQUE` (`OwnerName` ASC) VISIBLE,
                                               UNIQUE INDEX `ID_UNIQUE` (`ticketID` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `zooh`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`user` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `pin` CHAR(8) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 501
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `zooh`.`userticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`userticket` (
  `iduserticket` INT NOT NULL,
  `userID` INT NULL DEFAULT NULL,
  `ticketID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`iduserticket`),
  INDEX `userIDticket_idx` (`userID` ASC) VISIBLE,
  INDEX `ticketIDuser_idx` (`ticketID` ASC) VISIBLE,
  CONSTRAINT `ticketIDuser`
    FOREIGN KEY (`ticketID`)
    REFERENCES `zooh`.`ticket` (`ticketID`),
  CONSTRAINT `userIDticket`
    FOREIGN KEY (`userID`)
    REFERENCES `zooh`.`user` (`userID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
