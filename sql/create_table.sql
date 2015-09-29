DROP DATABASE diya_dahara;
CREATE DATABASE diya_dahara;
USE diya_dahara;

CREATE TABLE `room` (
  `id`                  BIGINT(10)                                                   NOT NULL AUTO_INCREMENT,
  `name`                VARCHAR(200)                                                 NOT NULL,
  `type`                ENUM('SINGLE', 'DOUBLE', 'FAMILY_SUIT', 'JUNIOR_SUIT')       NOT NULL,
  `category`            ENUM('BED', 'BED_AND_BREAKFAST', 'HALF_BOARD', 'FULL_BOARD') NOT NULL,
  `available`           TINYINT(1)                                                   NOT NULL,
  `description`         VARCHAR(1000)                                                NOT NULL,
  `price`               VARCHAR(20)                                                  NOT NULL,
  `check_in_date_time`  TIMESTAMP                                                             DEFAULT '0000-00-00 00:00:00',
  `check_out_date_time` TIMESTAMP                                                             DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `food` (
  `id`          BIGINT(10)                           NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(200)                         NOT NULL,
  `type`        ENUM('BREAKFAST', 'LUNCH', 'DINNER') NOT NULL,
  `quantity`    BIGINT(5)                            NOT NULL,
  `description` VARCHAR(1000)                        NOT NULL,
  `price`       VARCHAR(20)                          NOT NULL,
  `date_time`   TIMESTAMP                                     DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `table` (
  `id`          BIGINT(10)    NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(200)  NOT NULL,
  `available`   TINYINT(1)    NOT NULL,
  `chairs`      BIGINT(5),
  `description` VARCHAR(1000) NOT NULL,
  `price`       VARCHAR(20)   NOT NULL,
  `date_time`   TIMESTAMP              DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `tour` (
  `id`             BIGINT(10)    NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(200)  NOT NULL,
  `description`    VARCHAR(1000) NOT NULL,
  `contact_number` VARCHAR(15)   NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `transport` (
  `id`             BIGINT(10)    NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(200)  NOT NULL,
  `description`    VARCHAR(1000) NOT NULL,
  `contact_number` VARCHAR(15)   NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `customer` (
  `id`           BIGINT(10)   NOT NULL AUTO_INCREMENT,
  `nic`          BIGINT(10)   NOT NULL,
  `name`         VARCHAR(200) NOT NULL,
  `email`        VARCHAR(100) NOT NULL,
  `telephone`    VARCHAR(15)  NOT NULL,
  `country`      VARCHAR(50)  NOT NULL,
  `room_id`      BIGINT(10),
  `food_id`      BIGINT(10),
  `table_id`     BIGINT(10),
  `tour_id`      BIGINT(10),
  `transport_id` BIGINT(10),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  FOREIGN KEY (`table_id`) REFERENCES `table` (`id`),
  FOREIGN KEY (`food_id`) REFERENCES `food` (`id`),
  FOREIGN KEY (`tour_id`) REFERENCES `tour` (`id`),
  FOREIGN KEY (`transport_id`) REFERENCES `transport` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;