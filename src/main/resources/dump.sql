-- MySQL 8.0.28-0ubuntu0.21.10.3 dump
--
SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;
-- LEARN FAST DATABASE
DROP DATABASE IF EXISTS `LearnFast`;
CREATE DATABASE `LearnFast` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `LearnFast`;
-- USER TABLE
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(70) NOT NULL,
                        `last_name` varchar(70) NOT NULL,
                        `email` varchar(70) NOT NULL,
                        `username` varchar(70) NOT NULL,
                        `password` varchar(70) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`) VALUES
                  (1,	'Justin',	'Hoang',	'justin@gmail.com',	'justin',	'justin'),
                  (2,	'Yukiko',	'Ikeda',	'yukiko@gmail.com',	'yukiko',	'yukiko'),
                  (3,	'Kalaya',	'Aung',	'kalaya@gmail.com',	'kalaya',	'kalaya'),
                  (4,	'Buakaw',	'Banchamek',	'buakaw1@gmail.com',	'buakaw1',	'buakaw1'),
                  (5,	'Chai',	'Thongkham',	'chai@gmail.com',	'chai',	'chai'),
                  (6,	'Suphachai',	'Saepong',	'saenchai@gmail.com',	'saenchai',	'saenchai'),
                  (7,	'Pong',	'Baccam',	'pong@gmail.com',	'pong',	'pong');

-- ROLE TABLE
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `user_id` int NOT NULL,
                        `user_username` int NOT NULL,
                        `role` varchar(70) NOT NULL,
                        `createDate` timestamp NOT NULL,
                        `updateDate` timestamp NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `user_id` (`user_id`),
                        KEY `user_username` (`user_username`),
                        CONSTRAINT `role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                        CONSTRAINT `role_ibfk_2` FOREIGN KEY (`user_username`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `role` (`id`, `user_id`, `user_username`, `role`, `createDate`, `updateDate`) VALUES
                      (1,	1,	1,	'admin',	'2022-02-20 20:25:49',	'2022-02-20 20:25:49'),
                      (2,	2,	2,	'admin',	'2022-02-20 20:26:14',	'2022-02-20 20:26:14'),
                      (3,	3,	3,	'user',	'2022-02-20 20:26:27',	'2022-02-20 20:26:27'),
                      (4,	4,	4,	'user',	'2022-02-20 20:26:37',	'2022-02-20 20:26:37'),
                      (5,	5,	5,	'user',	'2022-02-20 20:26:47',	'2022-02-20 20:26:47'),
                      (6,	6,	6,	'user',	'2022-02-20 20:26:58',	'2022-02-20 20:26:58'),
                      (7,	7,	7,	'user',	'2022-02-20 20:27:13',	'2022-02-20 20:27:13');
--
