-- Adminer 4.8.1 MySQL 8.0.28 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `learnfasttest`;
CREATE DATABASE `learnfasttest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `learnfasttest`;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `id`             bigint                                                        NOT NULL AUTO_INCREMENT,
    `title`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `section`        varchar(50)                                                   NOT NULL,
    `format`         varchar(50)                                                   NOT NULL,
    `mentor`         varchar(70)                                                   NOT NULL,
    `section_status` varchar(50)                                                   NOT NULL,
    `meets`          varchar(50)                                                   NOT NULL,
    `dates`          varchar(50)                                                   NOT NULL,
    `description`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `mentor_id`      bigint DEFAULT NULL,
    `user_id`        bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKo8cd9ws5dj1nx96xjtynff72o` (`user_id`),
    CONSTRAINT `FKo8cd9ws5dj1nx96xjtynff72o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `course` (`id`, `title`, `section`, `format`, `mentor`,
                      `section_status`, `meets`, `dates`, `description`,
                      `mentor_id`, `user_id`)
VALUES (1, 'Technology Mentorship', '1', 'Online', 'Justin Hoang', 'Open',
        'On Demand', '6/21 to 8/5', 'Technology mentorship', NULL, NULL),
       (2, 'Technology Mentorship', '1',
        'Online (live or on demand) web conference', 'Justin Hoang', 'Open',
        'MTTh 6:30-8:30p', '6/21 to 8/5', 'Technology Mentorship', NULL, NULL)
ON DUPLICATE KEY UPDATE `id`             = VALUES(`id`),
                        `title`          = VALUES(`title`),
                        `section`        = VALUES(`section`),
                        `format`         = VALUES(`format`),
                        `mentor`         = VALUES(`mentor`),
                        `section_status` = VALUES(`section_status`),
                        `meets`          = VALUES(`meets`),
                        `dates`          = VALUES(`dates`),
                        `description`    = VALUES(`description`),
                        `mentor_id`      = VALUES(`mentor_id`),
                        `user_id`        = VALUES(`user_id`);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`           bigint                                                        NOT NULL AUTO_INCREMENT,
    `birthdate`    date                                                          NOT NULL,
    `given_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `family_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `email`        varchar(75) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `username`     varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `password`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `gender`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `create_date`  datetime                                                      DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `update_date`  datetime                                                      DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `username` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `user` (`id`, `birthdate`, `given_name`, `family_name`, `email`,
                    `phone_number`, `username`, `password`, `gender`,
                    `create_date`, `update_date`)
VALUES (1, '1992-01-01', 'Justin', 'Hoang', 'justin@gmail.com',
        '1-646-123-4567', 'justin', 'justin', 'Male', '2022-03-18 14:35:56',
        '2022-03-18 14:35:56'),
       (2, '1997-01-01', 'Yukiko', 'Ikeda', 'yukiko@gmail.com',
        '1-262-123-4567', 'yukiko', 'yukiko', 'Female', '2022-02-27 14:25:01',
        '2022-03-18 02:01:37'),
       (3, '1987-01-01', 'Kalaya', 'Aung', 'kalaya@gmail.com', '1-310-123-4567',
        'kalaya', 'kalaya', 'Female', '2022-02-27 14:25:01',
        '2022-03-18 02:02:16'),
       (4, '1982-05-08', 'Buakaw', 'Banchamek', 'buakaw1@gmail.com',
        '1-312-123-4567', 'buakaw1', 'buakaw1', 'Male', '2022-02-27 14:25:01',
        '2022-03-18 02:02:49'),
       (5, '2000-01-01', 'Chai', 'Thongkham', 'chai@gmail.com',
        '1-414-123-4567', 'chai', 'chai', 'Female', '2022-02-27 14:25:01',
        '2022-03-18 02:04:15'),
       (6, '1980-07-30', 'Suphachai', 'Saepong', 'saenchai@gmail.com',
        '1-617-123-4567', 'saenchai', 'saenchai', 'Male', '2022-02-27 14:25:01',
        '2022-03-18 02:04:50'),
       (7, '2004-01-01', 'Pong', 'Baccam', 'pong@gmail.com', '1-608-123-4567',
        'pong', 'pong', 'Female', '2022-02-27 14:25:01', '2022-02-27 14:25:01')
ON DUPLICATE KEY UPDATE `id`           = VALUES(`id`),
                        `birthdate`    = VALUES(`birthdate`),
                        `given_name`   = VALUES(`given_name`),
                        `family_name`  = VALUES(`family_name`),
                        `email`        = VALUES(`email`),
                        `phone_number` = VALUES(`phone_number`),
                        `username`     = VALUES(`username`),
                        `password`     = VALUES(`password`),
                        `gender`       = VALUES(`gender`),
                        `create_date`  = VALUES(`create_date`),
                        `update_date`  = VALUES(`update_date`);

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`            bigint      NOT NULL AUTO_INCREMENT,
    `role_name`     varchar(70) NOT NULL,
    `user_username` bigint      NOT NULL,
    `user_id`       bigint      NOT NULL,
    PRIMARY KEY (`id`),
    KEY `user_username` (`user_username`),
    KEY `user_id` (`user_id`),
    CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_username`) REFERENCES `user` (`id`) ON DELETE CASCADE,
    CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `user_role` (`id`, `role_name`, `user_username`, `user_id`)
VALUES (1, 'ADMIN', 1, 1),
       (2, 'ADMIN', 2, 2),
       (3, 'USER', 3, 3),
       (4, 'USER', 4, 4),
       (5, 'USER', 5, 5),
       (6, 'USER', 6, 6),
       (7, 'USER', 7, 7)
ON DUPLICATE KEY UPDATE `id`            = VALUES(`id`),
                        `role_name`     = VALUES(`role_name`),
                        `user_username` = VALUES(`user_username`),
                        `user_id`       = VALUES(`user_id`);

-- 2022-03-18 19:39:47
