/*Insert the equipements*/
INSERT INTO `tabletennisclub`.`equipment` (`reference`, `description`) VALUES (1, 'Women TShirt');
INSERT INTO `tabletennisclub`.`equipment` (`reference`, `description`) VALUES (2, 'Women Polo');
INSERT INTO `tabletennisclub`.`equipment` (`reference`, `description`) VALUES (3, 'Men TShirt');
INSERT INTO `tabletennisclub`.`equipment` (`reference`, `description`) VALUES (4, 'Men Polo');
INSERT INTO `tabletennisclub`.`equipment` (`reference`, `description`) VALUES (5, 'Women TShirt & Training');
INSERT INTO `tabletennisclub`.`equipment` (`reference`, `description`) VALUES (6, 'Women Polo & Training');
INSERT INTO `tabletennisclub`.`equipment` (`reference`, `description`) VALUES (7, 'Men TShirt & Training');
INSERT INTO `tabletennisclub`.`equipment` (`reference`, `description`) VALUES (8, 'Men Polo & Training');


/*Insert some affiliates*/
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('141736', 'Emma', 'Vandecasteele', 'W', '2000-11-19', '495636059', 'emma.vandecasteele@domain.be', '2', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('141737', 'Vicky', 'Zagorski', 'W', '2000-09-14', '495636060', 'vicky.zag@domain.be', '2', b'0');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('12696', 'Chantal', 'Bertrand', 'W', '1985-04-19', null, null, '1', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('13725', 'Françoise', 'Dubisy', 'W', '1985-04-18', null, null, '6', b'0');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('126897', 'Jean-Michel', 'Saive', 'M', '1969-11-17', null, null, '8', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('13726', 'Simon', 'Remels', 'M', '2002-09-24', null, null, '8', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('13727', 'Matteo', 'Mauro', 'M', '2003-08-16', null, null, '7', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('13728', 'Antoine', 'Walbrecq', 'M', '2003-05-11', null, null, '7', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('13729', 'Nicolas', 'Allegro', 'M', '2000-10-08', '498754811', null, '8', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('13730', 'Samy', 'Demarthe', 'M', '2000-10-09', '498752511', null, '7', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('13731', 'Louis', 'Vanadenhoven', 'M', '2000-09-11', null, null, '7', b'1');
INSERT INTO `tabletennisclub`.`affiliate` (`affiliate_id`, `first_name`, `last_name`, `gender`, `birth_date`, `phone`, `email`, `equipment_id`, `play_competition`) VALUES ('13732', 'Megane', 'Vandecasteele', 'W', '1999-02-13', '485636059', 'megane.vandecasteele@domain.be', '2', b'1');


/*Insert the rankings*/
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (1, 'B0');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (2, 'B2');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (3, 'B4');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (4, 'B6');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (5, 'C0');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (6, 'C2');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (7, 'C4');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (8, 'C6');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (9, 'D0');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (10, 'D2');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (11, 'D4');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (12, 'D6');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (13, 'E0');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (14, 'E2');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (15, 'E4');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (16, 'E6');
INSERT INTO `tabletennisclub`.`ranking` (`ranking_id`, `name`) VALUES (17, 'NC');

/*Insert the absences*/
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (1,1,'examen',12696);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (2,2,'travaux maison',12696);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (3,3,'pas envie',12696);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (4,1,'pas envie',141736);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (5,10,'examen',141736);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (6,1,'Je travaille',126897);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (7,2,'Je travaille',126897);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (8,2,'sortie anniversaire',13726);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (9,21,'sortie anniversaire',13726);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (10,21,'sortie anniversaire',13727);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (11,21,'sortie anniversaire',13728);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (12,1,'pas envie',13729);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (13,13,'pas envie',13730);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (14,11,'travaux maison',13730);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (15,11,'travaux maison',13731);
INSERT INTO `tabletennisclub`.`absence` (`absence_id`,`week_number`,`description`,`affiliate_id`) VALUES (16,4,'Je travaille',13732);


/*Insert the affiliate rankings*/
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (1,2018,141736,12,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (2,2019,141736,11,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (3,2018,141736,8,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (4,2019,141736,8,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (5,2018,12696,11,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (6,2019,12696,11,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (7,2018,12696,10,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (8,2019,12696,9,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (9,2018,141737,12,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (10,2019,141737,10,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (11,2019,141737,14,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (12,2018,13725,10,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (13,2019,13725,10,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (14,2019,13725,14,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (15,2019,126897,1,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (16,2018,13726,9,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (17,2019,13726,7,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (18,2019,13727,6,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (19,2019,13728,6,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (20,2019,13729,1,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (21,2019,13730,1,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (22,2019,13731,2,'M');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (23,2019,13732,2,'W');
INSERT INTO `tabletennisclub`.`affiliate_ranking` (`affiliate_ranking_id`,`season`,`affiliate_id`,`ranking_id`,`gender`) VALUES (24,2019,13732,6,'M');



/*Insert the trainers*/
INSERT INTO `tabletennisclub`.`trainer` (`trainer_id`, `first_name`, `last_name`, `phone`) VALUES (1, 'Clement', 'Demanet', '493661067');
INSERT INTO `tabletennisclub`.`trainer` (`trainer_id`, `first_name`, `last_name`, `phone`) VALUES (2, 'Xavier', 'Coppee', '499109500');
INSERT INTO `tabletennisclub`.`trainer` (`trainer_id`, `first_name`, `last_name`, `phone`) VALUES (3, 'Gérard', 'Hennin', '463561068');

/*Insert the rooms*/
INSERT INTO `tabletennisclub`.`room` (`number`, `street_name`, `street_number`, `postal_code`,`locality`) VALUES (1, 'Drèves des Alliés','120', 6530, 'Thuin');
INSERT INTO `tabletennisclub`.`room` (`number`, `street_name`, `street_number`, `postal_code`,`locality`) VALUES (2, 'Drèves des Alliés','121', 6530, 'Thuin');
INSERT INTO `tabletennisclub`.`room` (`number`, `street_name`, `street_number`, `postal_code`,`locality`) VALUES (3, 'Rue des Fossés','15', 6120, 'Nalinnes');

/*Insert the training groups*/
INSERT INTO `tabletennisclub`.`training_group` (`training_group_id`, `time_start`, `time_end`, `day`,`trainer_id`, `room_id`) VALUES (1, 183000, 193000, 1, 3, 1);
INSERT INTO `tabletennisclub`.`training_group` (`training_group_id`, `time_start`, `time_end`, `day`,`trainer_id`, `room_id`) VALUES (2, 180000, 193000, 2, 1, 1);
INSERT INTO `tabletennisclub`.`training_group` (`training_group_id`, `time_start`, `time_end`, `day`,`trainer_id`, `room_id`) VALUES (3, 183000, 193000, 3, 1, 2);
INSERT INTO `tabletennisclub`.`training_group` (`training_group_id`, `time_start`, `time_end`, `day`,`trainer_id`, `room_id`) VALUES (4, 193000, 203000, 3, 2, 1);
INSERT INTO `tabletennisclub`.`training_group` (`training_group_id`, `time_start`, `time_end`, `day`,`trainer_id`, `room_id`) VALUES (5, 181500, 194500, 4, 2, 3);

/*Insert the trainings*/
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (1,141736);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (2,141736);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (2,12696);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (3,141737);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (4,141737);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (3,13725);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (5,13725);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (1,126897);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (1,13726);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (5,13726);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (2,13727);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (2,13728);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (1,13729);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (5,13730);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (4,13731);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (5,13731);
INSERT INTO `tabletennisclub`.`training` (`training_group_id`,`affiliate_id`) VALUES (1,13732);