-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema zooh
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `zooh`;

-- -----------------------------------------------------
-- Schema zooh
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zooh` DEFAULT CHARACTER SET utf8;

-- -----------------------------------------------------
-- Schema zooh
-- -----------------------------------------------------
USE `zooh`;

-- -----------------------------------------------------
-- Table `zooh`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`user` (
                                             `userid` INT NOT NULL AUTO_INCREMENT,
                                             `username` VARCHAR(255) NOT NULL,
                                             `password` VARCHAR(255) NOT NULL,
                                             PRIMARY KEY (`userid`),
                                             UNIQUE INDEX `userid_UNIQUE` (`userid` ASC) VISIBLE
) ENGINE = InnoDB;

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
                                                       ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `zooh`.`animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`animal` (
                                               `animalID` INT NOT NULL AUTO_INCREMENT,
                                               `specie` VARCHAR(255) NOT NULL,
                                               `name` VARCHAR(255) NOT NULL,
                                               `age` INT NOT NULL,
                                               `locationID` INT NOT NULL,
                                               PRIMARY KEY (`animalID`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `zooh`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`tag` (
                                            `tagID` INT NOT NULL AUTO_INCREMENT,
                                            `tagname` VARCHAR(255) NOT NULL,
                                            PRIMARY KEY (`tagID`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `zooh`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zooh`.`event` (
                                              `eventID` INT NOT NULL AUTO_INCREMENT,
                                              `name` VARCHAR(255) NOT NULL,
                                              `tagIDFS` INT NOT NULL,
                                              `time` DATETIME,
                                              PRIMARY KEY (`eventID`),
                                              INDEX `tagIDFS_idx` (`tagIDFS` ASC) VISIBLE,
                                              CONSTRAINT `tagIDFStotagID`
                                                  FOREIGN KEY (`tagIDFS`)
                                                      REFERENCES `zooh`.`tag` (`tagID`)
                                                      ON DELETE NO ACTION
                                                      ON UPDATE NO ACTION
) ENGINE = InnoDB;

INSERT INTO zooh.animal (specie, name, age, locationID) VALUES
                                                            ('Lion', 'Simba', 5, 1),
                                                            ('Elephant', 'Dumbo', 3, 2),
                                                            ('Giraffe', 'Melman', 4, 3),
                                                            ('Penguin', 'Skipper', 2, 4),
                                                            ('Kangaroo', 'Jack', 3, 5);

INSERT INTO zooh.tag (tagname) VALUES
                                   ('Family event'),
                                   ('Children'),
                                   ('Visual'),
                                   ('Relaxing');

INSERT INTO zooh.event (name, tagIDFS, time) VALUES
                                                 ('Feeding Time', 1, '2024-01-26 10:00:00'),
                                                 ('Bird Show', 4, '2024-01-27 14:30:00'),
                                                 ('Elephant Bath', 3, '2024-01-28 11:15:00'),
                                                 ('Lion Roaring Session', 1, '2024-01-29 15:45:00'),
                                                 ('Goat Feeding', 2, '2024-01-30 13:00:00');

INSERT INTO zooh.user (username, password) VALUES
                                               ('john_doe', 'password123'),
                                               ('jane_smith', 'securepass'),
                                               ('bob_jones', 'letmein');

INSERT INTO zooh.ticket (ticketid, used, cost, userid, expirationdate) VALUES
                                                                           (1, 0, 10.50, 1, '2024-02-01'),
                                                                           (2, 1, 8.75, 2, '2024-02-05'),
                                                                           (3, 0, 12.00, 3, '2024-02-10');



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

USE zooh;

SELECT * FROM animal;
SELECT * FROM event;
SELECT * FROM tag;
SELECT * FROM ticket;
SELECT * FROM user;