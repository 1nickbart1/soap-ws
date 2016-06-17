CREATE schema IF NOT EXISTS `ws-db`;

CREATE TABLE IF NOT EXISTS `ws-db`.`message` (
  `id` INT  AUTO_INCREMENT,
  `create_date` DATE ,
  `message_id` VARCHAR(45) NOT NULL,
  `original_data` BLOB NOT NULL,
  `sign_key` BLOB NOT NULL,
  `encoded_data` BLOB NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

USE `ws-db`;

DELIMITER $$
USE `ws-db`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ws-db`.`message` BEFORE INSERT ON `message` FOR EACH ROW
    set new.create_date=now()$$


DELIMITER ;