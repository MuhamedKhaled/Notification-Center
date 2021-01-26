#CREATE DATABASE `notification`;

CREATE TABLE `notification` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `title` varchar(45) DEFAULT NULL,
                                `body` varchar(45) DEFAULT NULL,
                                `consumers` varchar(1000) NOT NULL,
                                `kind` varchar(45) NOT NULL,
                                `providers` varchar(1000) NOT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(45) DEFAULT NULL,
                        `email` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
