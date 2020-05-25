CREATE DATABASE `tabletennisclub` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE tabletennisclub;
CREATE TABLE `equipment` (
  `reference` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `affiliate` (
  `affiliate_id` int NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birth_date` date NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `equipment_id` int NOT NULL,
  `play_competition` bit(1) NOT NULL,
  PRIMARY KEY (`affiliate_id`),
  KEY `equipment_id_idx` (`equipment_id`),
  CONSTRAINT `equipment_id` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`reference`),
  CONSTRAINT chk_date CHECK(birth_date > '1899-12-31' AND birth_date < sysdate())
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `absence` (
  `absence_id` int NOT NULL AUTO_INCREMENT,
  `week_number` int NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `affiliate_id` int NOT NULL,
  PRIMARY KEY (`absence_id`),
  KEY `fk_affiliate_id_idx` (`affiliate_id`),
  CONSTRAINT `fk_absence_affiliate_id` FOREIGN KEY (`affiliate_id`) REFERENCES `affiliate` (`affiliate_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8;


CREATE TABLE `ranking` (
  `ranking_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ranking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

CREATE TABLE `affiliate_ranking` (
  `affiliate_ranking_id` int NOT NULL AUTO_INCREMENT,
  `season` int NOT NULL,
  `affiliate_id` int NOT NULL,
  `ranking_id` int NOT NULL,
  `gender` char(1) NOT NULL,
  PRIMARY KEY (`affiliate_ranking_id`),
  KEY `affiliate_id_idx` (`affiliate_id`),
  KEY `fk_ranking_id_idx` (`ranking_id`),
  CONSTRAINT `fk__affiliate_ranking_ranking_id` FOREIGN KEY (`ranking_id`) REFERENCES `ranking` (`ranking_id`),
  CONSTRAINT `fk_affiliate_ranking_affiliate_id` FOREIGN KEY (`affiliate_id`) REFERENCES `affiliate` (`affiliate_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

CREATE TABLE `room` (
  `number` int NOT NULL,
  `street_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `street_number` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `postal_code` int NOT NULL,
  `locality` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `trainer` (
  `trainer_id` int NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `training_group` (
  `training_group_id` int NOT NULL,
  `time_start` time NOT NULL,
  `time_end` time NOT NULL,
  `day` int NOT NULL,
  `trainer_id` int NOT NULL,
  `room_id` int NOT NULL,
  PRIMARY KEY (`training_group_id`),
  KEY `trainer_id_idx` (`trainer_id`),
  KEY `fk_room_id_idx` (`room_id`),
  CONSTRAINT `fk_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`number`),
  CONSTRAINT `fk_trainer_id` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `training` (
  `training_group_id` int NOT NULL,
  `affiliate_id` int NOT NULL,
  PRIMARY KEY (`training_group_id`,`affiliate_id`),
  KEY `fk_training_affiliate_id_idx` (`affiliate_id`),
  CONSTRAINT `fk_training_affiliate_id` FOREIGN KEY (`affiliate_id`) REFERENCES `affiliate` (`affiliate_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_training_training_group_id` FOREIGN KEY (`training_group_id`) REFERENCES `training_group` (`training_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
