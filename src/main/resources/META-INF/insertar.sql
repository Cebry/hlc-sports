INSERT INTO `role` (`id`, `name`, `description`) VALUES (4, 'Kette', '');
INSERT INTO `role` (`id`, `name`, `description`) VALUES (3, 'Escolta', '');
INSERT INTO `role` (`id`, `name`, `description`) VALUES (1, 'Antikette', '');
INSERT INTO `role` (`id`, `name`, `description`) VALUES (2, 'Medio', '');
INSERT INTO `role` (`id`, `name`, `description`) VALUES (5, 'Corredor', '');

INSERT INTO `team` (`id`, `name`, `initials`) VALUES ('1', 'BICIOSOS', 'BJT');
INSERT INTO `team` (`id`, `name`, `initials`) VALUES ('2', 'LINCES', 'LJC');

INSERT INTO `player` (`id`, `name`, `dorsal_name`, `dorsal_number`, `is_captain`, `team_id`) VALUES (1, 'Javier', 'Cebry', '3', 0, 1);
INSERT INTO `player` (`id`, `name`, `dorsal_name`, `dorsal_number`, `is_captain`, `team_id`) VALUES (2, 'Alba', 'Alba', '2', 0, 1);
INSERT INTO `player` (`id`, `name`, `dorsal_name`, `dorsal_number`, `is_captain`, `team_id`) VALUES (3, 'Mapi', 'Mapi', '1', 1, 1);

INSERT INTO `player` (`id`, `name`, `dorsal_name`, `dorsal_number`, `is_captain`, `team_id`) VALUES (4, 'Juan', 'Nillo', '3', 0, 2);
INSERT INTO `player` (`id`, `name`, `dorsal_name`, `dorsal_number`, `is_captain`, `team_id`) VALUES (5, 'Joaquin', 'Quine', '2', 0, 2);
INSERT INTO `player` (`id`, `name`, `dorsal_name`, `dorsal_number`, `is_captain`, `team_id`) VALUES (6, 'Ezequiel', 'Zequi', '1', 1, 2);

INSERT INTO `player-role` (`player_id`, `role_id`) VALUES ('1', '4');
INSERT INTO `player-role` (`player_id`, `role_id`) VALUES ('2', '3');
INSERT INTO `player-role` (`player_id`, `role_id`) VALUES ('3', '4');
INSERT INTO `player-role` (`player_id`, `role_id`) VALUES ('4', '4');
INSERT INTO `player-role` (`player_id`, `role_id`) VALUES ('5', '1');
INSERT INTO `player-role` (`player_id`, `role_id`) VALUES ('6', '4');	