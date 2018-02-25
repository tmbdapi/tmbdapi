-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tutor_media
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tutor_media
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tutor_media` DEFAULT CHARACTER SET utf8 ;
USE `tutor_media` ;

-- -----------------------------------------------------
-- Table `tutor_media`.`accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutor_media`.`accounts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `gender` TINYINT(2) NOT NULL,
  `role` TINYINT(2) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tutor_media`.`institutions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutor_media`.`institutions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(200) NOT NULL,
  `short_name` VARCHAR(10) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `full_name_UNIQUE` (`full_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tutor_media`.`subjects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutor_media`.`subjects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(200) NOT NULL,
  `short_name` VARCHAR(10) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `full_name_UNIQUE` (`full_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tutor_media`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutor_media`.`teachers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NOT NULL,
  `current_institution` INT NOT NULL,
  `subject_of_study` INT NOT NULL,
  `subject_of_interest` VARCHAR(250) NOT NULL,
  `interested_medium` VARCHAR(100) NOT NULL,
  `age` INT NOT NULL,
  `status` TINYINT(2) NOT NULL,
  `introduction` VARCHAR(250) NULL,
  PRIMARY KEY (`id`),
  INDEX `teacher_instuition_fk_id_idx` (`current_institution` ASC),
  INDEX `teacher_account_fk_id_idx` (`account_id` ASC),
  INDEX `teacher_subject_fk_id_idx` (`subject_of_study` ASC),
  CONSTRAINT `teacher_institution_fk_id`
    FOREIGN KEY (`current_institution`)
    REFERENCES `tutor_media`.`institutions` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `teacher_account_fk_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `tutor_media`.`accounts` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `teacher_subject_fk_id`
    FOREIGN KEY (`subject_of_study`)
    REFERENCES `tutor_media`.`subjects` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tutor_media`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutor_media`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NOT NULL,
  `title` VARCHAR(150) NOT NULL,
  `number_of_student` INT NOT NULL,
  `institution_id` INT NOT NULL,
  `class` INT NOT NULL,
  `medium` INT NOT NULL,
  `salary_min` INT NOT NULL,
  `salary_max` INT NOT NULL,
  `subjects` VARCHAR(250) NOT NULL,
  `days_per_week` INT NOT NULL,
  `city` VARCHAR(45) NULL,
  `address` VARCHAR(250) NOT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `post_instituition_fk_id_idx` (`institution_id` ASC),
  INDEX `post_account_fk_id_idx` (`account_id` ASC),
  CONSTRAINT `post_institution_fk_id`
    FOREIGN KEY (`institution_id`)
    REFERENCES `tutor_media`.`institutions` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `post_account_fk_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `tutor_media`.`accounts` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tutor_media`.`requests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutor_media`.`requests` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `post_id` INT NOT NULL,
  `teacher_id` INT NOT NULL,
  `type` TINYINT(2) NOT NULL,
  `status` TINYINT(2) NOT NULL,
  `expired_at` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `request_post_fk_id_idx` (`post_id` ASC),
  INDEX `request_teacher_fk_id_idx` (`teacher_id` ASC),
  UNIQUE INDEX `post_teacher_index_unique` (`post_id` ASC, `teacher_id` ASC),
  CONSTRAINT `request_post_fk_id`
    FOREIGN KEY (`post_id`)
    REFERENCES `tutor_media`.`posts` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `request_teacher_fk_id`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `tutor_media`.`teachers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tutor_media`.`request_proccess`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutor_media`.`request_proccess` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `request_state` TINYINT(2) UNSIGNED NOT NULL,
  `post_id` INT NULL,
  `teacher_id` INT NULL,
  `accept_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `request_process_post_fk_id_idx_idx` (`post_id` ASC),
  INDEX `request_process_teacher_fk_id_idx` (`teacher_id` ASC),
  CONSTRAINT `request_process_post_fk_id_idx`
    FOREIGN KEY (`post_id`)
    REFERENCES `tutor_media`.`posts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `request_process_teacher_fk_id`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `tutor_media`.`teachers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tutor_media`.`notifications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutor_media`.`notifications` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NOT NULL,
  `post_id` INT NOT NULL,
  `status` TINYINT NOT NULL,
  `type` TINYINT(2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `notification_account_fk_id_idx` (`account_id` ASC),
  INDEX `notification_post_fk_id_idx_idx` (`post_id` ASC),
  CONSTRAINT `notification_account_fk_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `tutor_media`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `notification_post_fk_id_idx`
    FOREIGN KEY (`post_id`)
    REFERENCES `tutor_media`.`posts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;