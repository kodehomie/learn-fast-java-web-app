-- Adminer 4.8.1 MySQL 8.0.28 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `title` varchar(70) NOT NULL,
                          `section` int NOT NULL,
                          `format` varchar(70) NOT NULL,
                          `mentor_first_name` int NOT NULL,
                          `mentor_last_name` int NOT NULL,
                          `section_status` varchar(70) NOT NULL,
                          `meets` varchar(70) NOT NULL,
                          `start_date` date NOT NULL,
                          `end_date` date NOT NULL,
                          `description` varchar(255) NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `mentor_first_name` (`mentor_first_name`),
                          KEY `mentor_last_name` (`mentor_last_name`),
                          CONSTRAINT `course_ibfk_1` FOREIGN KEY (`mentor_first_name`) REFERENCES `mentor` (`id`),
                          CONSTRAINT `course_ibfk_2` FOREIGN KEY (`mentor_last_name`) REFERENCES `mentor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `course` (`id`, `title`, `section`, `format`, `mentor_first_name`, `mentor_last_name`, `section_status`, `meets`, `start_date`, `end_date`, `description`) VALUES
                                                                                                                                                                           (1,	'Technology Mentorship',	1,	'Online (live or on demand) web conference',	1,	1,	'Open',	'MTTh 6:30-8:30p',	'2022-06-21',	'2022-08-05',	'Classroom one-to-many style technology mentorship.'),
                                                                                                                                                                           (2,	'Industrial Ecology Mentorship',	2,	'In-person or Online',	2,	2,	'Open',	'TTh 3:15-6:15p',	'2022-06-21',	'2022-08-05',	'Personal one-to-one style industrial ecology mentorship.')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `title` = VALUES(`title`), `section` = VALUES(`section`), `format` = VALUES(`format`), `mentor_first_name` = VALUES(`mentor_first_name`), `mentor_last_name` = VALUES(`mentor_last_name`), `section_status` = VALUES(`section_status`), `meets` = VALUES(`meets`), `start_date` = VALUES(`start_date`), `end_date` = VALUES(`end_date`), `description` = VALUES(`description`);

DROP TABLE IF EXISTS `enrollment`;
CREATE TABLE `enrollment` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `mentee_id` int NOT NULL,
                              `course_id` int NOT NULL,
                              `course_title` int NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `course_id` (`course_id`),
                              KEY `course_title` (`course_title`),
                              KEY `mentee_id` (`mentee_id`),
                              CONSTRAINT `enrollment_ibfk_1` FOREIGN KEY (`mentee_id`) REFERENCES `mentee` (`id`),
                              CONSTRAINT `enrollment_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
                              CONSTRAINT `enrollment_ibfk_3` FOREIGN KEY (`course_title`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `enrollment` (`id`, `mentee_id`, `course_id`, `course_title`) VALUES
                                                                              (1,	1,	1,	1),
                                                                              (2,	1,	2,	2),
                                                                              (3,	2,	1,	1),
                                                                              (4,	3,	2,	2)
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `mentee_id` = VALUES(`mentee_id`), `course_id` = VALUES(`course_id`), `course_title` = VALUES(`course_title`);

DROP TABLE IF EXISTS `mentee`;
CREATE TABLE `mentee` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `user_id` int NOT NULL,
                          `user_first_name` int NOT NULL,
                          `user_last_name` int NOT NULL,
                          `user_email` int NOT NULL,
                          `user_username` int NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `user_email` (`user_email`),
                          KEY `user_first_name` (`user_first_name`),
                          KEY `user_id` (`user_id`),
                          KEY `user_last_name` (`user_last_name`),
                          KEY `user_username` (`user_username`),
                          CONSTRAINT `mentee_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                          CONSTRAINT `mentee_ibfk_2` FOREIGN KEY (`user_first_name`) REFERENCES `user` (`id`),
                          CONSTRAINT `mentee_ibfk_3` FOREIGN KEY (`user_last_name`) REFERENCES `user` (`id`),
                          CONSTRAINT `mentee_ibfk_4` FOREIGN KEY (`user_email`) REFERENCES `user` (`id`),
                          CONSTRAINT `mentee_ibfk_5` FOREIGN KEY (`user_username`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `mentee` (`id`, `user_id`, `user_first_name`, `user_last_name`, `user_email`, `user_username`) VALUES
                                                                                                               (1,	3,	3,	3,	3,	3),
                                                                                                               (2,	4,	4,	4,	4,	4),
                                                                                                               (3,	5,	5,	5,	5,	5),
                                                                                                               (4,	6,	6,	6,	6,	6),
                                                                                                               (5,	7,	7,	7,	7,	7)
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `user_id` = VALUES(`user_id`), `user_first_name` = VALUES(`user_first_name`), `user_last_name` = VALUES(`user_last_name`), `user_email` = VALUES(`user_email`), `user_username` = VALUES(`user_username`);

DROP TABLE IF EXISTS `mentor`;
CREATE TABLE `mentor` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `user_id` int NOT NULL,
                          `user_first_name` int NOT NULL,
                          `user_last_name` int NOT NULL,
                          `user_email` int NOT NULL,
                          `user_username` int NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `user_email` (`user_email`),
                          KEY `user_first_name` (`user_first_name`),
                          KEY `user_id` (`user_id`),
                          KEY `user_last_name` (`user_last_name`),
                          KEY `user_username` (`user_username`),
                          CONSTRAINT `mentor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                          CONSTRAINT `mentor_ibfk_2` FOREIGN KEY (`user_first_name`) REFERENCES `user` (`id`),
                          CONSTRAINT `mentor_ibfk_3` FOREIGN KEY (`user_last_name`) REFERENCES `user` (`id`),
                          CONSTRAINT `mentor_ibfk_4` FOREIGN KEY (`user_email`) REFERENCES `user` (`id`),
                          CONSTRAINT `mentor_ibfk_5` FOREIGN KEY (`user_username`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `mentor` (`id`, `user_id`, `user_first_name`, `user_last_name`, `user_email`, `user_username`) VALUES
                                                                                                               (1,	1,	1,	1,	1,	1),
                                                                                                               (2,	2,	2,	2,	2,	2)
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `user_id` = VALUES(`user_id`), `user_first_name` = VALUES(`user_first_name`), `user_last_name` = VALUES(`user_last_name`), `user_email` = VALUES(`user_email`), `user_username` = VALUES(`user_username`);

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
                         `id` int NOT NULL,
                         `description` varchar(255) NOT NULL,
                         `user_id` int NOT NULL,
                         KEY `user_id` (`user_id`),
                         CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `user_id` int NOT NULL,
                        `user_username` int NOT NULL,
                        `role` varchar(70) NOT NULL,
                        `create_date` timestamp NOT NULL,
                        `update_date` timestamp NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `user_id` (`user_id`),
                        KEY `user_username` (`user_username`),
                        CONSTRAINT `role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                        CONSTRAINT `role_ibfk_2` FOREIGN KEY (`user_username`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `role` (`id`, `user_id`, `user_username`, `role`, `create_date`, `update_date`) VALUES
                                                                                                (1,	1,	1,	'admin',	'2022-02-21 02:25:49',	'2022-02-21 02:25:49'),
                                                                                                (2,	2,	2,	'admin',	'2022-02-21 02:26:14',	'2022-02-21 02:26:14'),
                                                                                                (3,	3,	3,	'user',	'2022-02-21 02:26:27',	'2022-02-21 02:26:27'),
                                                                                                (4,	4,	4,	'user',	'2022-02-21 02:26:37',	'2022-02-21 02:26:37'),
                                                                                                (5,	5,	5,	'user',	'2022-02-21 02:26:47',	'2022-02-21 02:26:47'),
                                                                                                (6,	6,	6,	'user',	'2022-02-21 02:26:58',	'2022-02-21 02:26:58'),
                                                                                                (7,	7,	7,	'user',	'2022-02-21 02:27:13',	'2022-02-21 02:27:13')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `user_id` = VALUES(`user_id`), `user_username` = VALUES(`user_username`), `role` = VALUES(`role`), `create_date` = VALUES(`create_date`), `update_date` = VALUES(`update_date`);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(70) NOT NULL,
                        `last_name` varchar(70) NOT NULL,
                        `email` varchar(70) NOT NULL,
                        `username` varchar(70) NOT NULL,
                        `password` varchar(70) NOT NULL,
                        `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `create_date`, `update_date`) VALUES
                                                                                                                        (1,	'Justin',	'Hoang',	'justin@gmail.com',	'justin',	'justin',	'2022-02-27 14:25:01',	'2022-02-27 14:25:01'),
                                                                                                                        (2,	'Yukiko',	'Ikeda',	'yukiko@gmail.com',	'yukiko',	'yukiko',	'2022-02-27 14:25:01',	'2022-02-27 14:25:01'),
                                                                                                                        (3,	'Kalaya',	'Aung',	'kalaya@gmail.com',	'kalaya',	'kalaya',	'2022-02-27 14:25:01',	'2022-02-27 14:25:01'),
                                                                                                                        (4,	'Buakaw',	'Banchamek',	'buakaw1@gmail.com',	'buakaw1',	'buakaw1',	'2022-02-27 14:25:01',	'2022-02-27 14:25:01'),
                                                                                                                        (5,	'Chai',	'Thongkham',	'chai@gmail.com',	'chai',	'chai',	'2022-02-27 14:25:01',	'2022-02-27 14:25:01'),
                                                                                                                        (6,	'Suphachai',	'Saepong',	'saenchai@gmail.com',	'saenchai',	'saenchai',	'2022-02-27 14:25:01',	'2022-02-27 14:25:01'),
                                                                                                                        (7,	'Pong',	'Baccam',	'pong@gmail.com',	'pong',	'pong',	'2022-02-27 14:25:01',	'2022-02-27 14:25:01')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `first_name` = VALUES(`first_name`), `last_name` = VALUES(`last_name`), `email` = VALUES(`email`), `username` = VALUES(`username`), `password` = VALUES(`password`), `create_date` = VALUES(`create_date`), `update_date` = VALUES(`update_date`);

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `role_name` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `user_name` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `user_id` int NOT NULL,
                              PRIMARY KEY (`user_name`,`role_name`),
                              UNIQUE KEY `id` (`id`),
                              KEY `user_id` (`user_id`),
                              CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 2022-02-27 20:52:04
