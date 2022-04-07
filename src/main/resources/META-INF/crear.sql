CREATE TABLE `player` (  `id` int NOT NULL,  `name` varchar(256) NOT NULL,  `dorsal_name` varchar(256) DEFAULT NULL,  `dorsal_number` int DEFAULT NULL,  `is_captain` tinyint(1) DEFAULT 0 NOT NULL,  `team_id` int DEFAULT NULL);
CREATE TABLE `player-role` (  `player_id` int NOT NULL,  `role_id` int NOT NULL);
CREATE TABLE `role` (  `id` int NOT NULL,  `name` varchar(256) NOT NULL,  `description` varchar(256) NOT NULL);
CREATE TABLE `team` (  `id` int NOT NULL,  `name` varchar(256) NOT NULL,  `initials` varchar(6) NOT NULL);

ALTER TABLE `player`  ADD PRIMARY KEY (`id`),  ADD KEY `FOREIGN_KEY_PLAYER_TEAM_ID` (`team_id`);
ALTER TABLE `player-role`  ADD PRIMARY KEY (`player_id`,`role_id`),  ADD KEY `FOREIGN_KEY_PLAYER-ROLE_ROLE_ID` (`role_id`);
ALTER TABLE `role`  ADD PRIMARY KEY (`id`);
ALTER TABLE `team`  ADD PRIMARY KEY (`id`);
ALTER TABLE `player`  MODIFY `id` int NOT NULL AUTO_INCREMENT;
ALTER TABLE `role`  MODIFY `id` int NOT NULL AUTO_INCREMENT;
ALTER TABLE `team`  MODIFY `id` int NOT NULL AUTO_INCREMENT;
ALTER TABLE `player`  ADD CONSTRAINT `FOREIGN_KEY_PLAYER_TEAM_ID` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE `player-role`  ADD CONSTRAINT `FOREIGN_KEY_PLAYER-ROLE_PLAYER_ID` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,  ADD CONSTRAINT `FOREIGN_KEY_PLAYER-ROLE_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;