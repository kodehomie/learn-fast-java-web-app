-- Adminer 4.8.1 MySQL 8.0.28 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `learnfast`;
CREATE DATABASE `learnfast` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `learnfast`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `birthdate`   date         NOT NULL,
    `first_name`  varchar(75)  NOT NULL,
    `last_name`   varchar(70)  NOT NULL,
    `email`       varchar(75)  NOT NULL,
    `phone`       varchar(25)  NOT NULL,
    `username`    varchar(70)  NOT NULL,
    `password`    varchar(255) NOT NULL,
    `create_time` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `update_time` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `phone` (`phone`),
    UNIQUE KEY `username` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `user` (`id`, `birthdate`, `first_name`, `last_name`, `email`, `phone`, `username`, `password`,
                    `create_time`, `update_time`)
VALUES (1, '1992-01-01', 'Justin', 'Hoang', 'justin@gmail.com', '1-646-123-4567', 'justin', 'justin',
        '2022-02-27 14:25:01', '2022-02-27 14:25:01'),
       (2, '1997-01-01', 'Yukiko', 'Ikeda', 'yukiko@gmail.com', '1-262-123-4567', 'yukiko', 'yukiko',
        '2022-02-27 14:25:01', '2022-02-27 14:25:01'),
       (3, '1987-01-01', 'Kalaya', 'Aung', 'kalaya@gmail.com', '1-310-123-4567', 'kalaya', 'kalaya',
        '2022-02-27 14:25:01', '2022-02-27 14:25:01'),
       (4, '1982-05-08', 'Buakaw', 'Banchamek', 'buakaw1@gmail.com', '1-312-123-4567', 'buakaw1', 'buakaw1',
        '2022-02-27 14:25:01', '2022-02-27 14:25:01'),
       (5, '2000-01-01', 'Chai', 'Thongkham', 'chai@gmail.com', '1-414-123-4567', 'chai', 'chai', '2022-02-27 14:25:01',
        '2022-02-27 14:25:01'),
       (6, '1980-07-30', 'Suphachai', 'Saepong', 'saenchai@gmail.com', '1-617-123-4567', 'saenchai', 'saenchai',
        '2022-02-27 14:25:01', '2022-02-27 14:25:01'),
       (7, '2004-01-01', 'Pong', 'Baccam', 'pong@gmail.com', '1-608-123-4567', 'pong', 'pong', '2022-02-27 14:25:01',
        '2022-02-27 14:25:01')
ON DUPLICATE KEY UPDATE `id`          = VALUES(`id`),
                        `birthdate`   = VALUES(`birthdate`),
                        `first_name`  = VALUES(`first_name`),
                        `last_name`   = VALUES(`last_name`),
                        `email`       = VALUES(`email`),
                        `phone`       = VALUES(`phone`),
                        `username`    = VALUES(`username`),
                        `password`    = VALUES(`password`),
                        `create_time` = VALUES(`create_time`),
                        `update_time` = VALUES(`update_time`);

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

-- 2022-02-28 21:37:05
