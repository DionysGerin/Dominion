/*
SQLyog Community v12.14 (32 bit)
MySQL - 5.6.17 : Database - dbdominion
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dbdominion` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dbdominion`;

/*Table structure for table `ability` */

DROP TABLE IF EXISTS `ability`;

CREATE TABLE `ability` (
  `cardnumber` int(11) NOT NULL,
  `abilitynr` int(11) NOT NULL,
  PRIMARY KEY (`cardnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ability` */

insert  into `ability`(`cardnumber`,`abilitynr`) values 
(1,8),
(2,9),
(3,10),
(4,11),
(5,12),
(6,13),
(7,14),
(8,15),
(9,16),
(10,17),
(11,18),
(12,19),
(13,20),
(14,21),
(15,22),
(16,23),
(17,24),
(18,25),
(19,26),
(20,27),
(21,28),
(22,29),
(23,30),
(24,31),
(25,32);

/*Table structure for table `cards` */

DROP TABLE IF EXISTS `cards`;

CREATE TABLE `cards` (
  `cardnumber` int(11) NOT NULL,
  `cardname` text,
  `cost` int(11) DEFAULT NULL,
  `cardtype` text,
  PRIMARY KEY (`cardnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cards` */

insert  into `cards`(`cardnumber`,`cardname`,`cost`,`cardtype`) values 
(1,'Copper',0,'Treasure'),
(2,'Silver',3,'Treasure'),
(3,'Gold',6,'Treasure'),
(4,'Estate',2,'Victory'),
(5,'Duchy',5,'Victory'),
(6,'Province',8,'Victory'),
(7,'Curse',0,'Victory'),
(8,'Cellar',2,'Action'),
(9,'Chapel',2,'Action'),
(10,'Moat',2,'Action'),
(11,'Workshop',3,'Action'),
(12,'Chancellor',3,'Action'),
(13,'Village',3,'Action'),
(14,'Woodcutter',3,'Action'),
(15,'Feast',4,'Action'),
(16,'Militia',4,'Action'),
(17,'Moneylender',4,'Action'),
(18,'Remodel',4,'Action'),
(19,'Bureaucrat',4,'Action'),
(20,'Smithy',4,'Action'),
(21,'Spy',4,'Action'),
(22,'Thief',4,'Action'),
(23,'Trone Room',4,'Action'),
(24,'Gardens',4,'Action'),
(25,'Council Room',5,'Action'),
(26,'Festival',5,'Action'),
(27,'Laboratory',5,'Action'),
(28,'Library',5,'Action'),
(29,'Market',5,'Action'),
(30,'Mine',5,'Action'),
(31,'Witch',5,'Action'),
(32,'Adventurer',6,'Action');

/*Table structure for table `treasurecard` */

DROP TABLE IF EXISTS `treasurecard`;

CREATE TABLE `treasurecard` (
  `TrCrdNr` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `cardnumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`TrCrdNr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `treasurecard` */

insert  into `treasurecard`(`TrCrdNr`,`value`,`cardnumber`) values 
(1,1,1),
(2,2,2),
(3,3,3);

/*Table structure for table `victorycard` */

DROP TABLE IF EXISTS `victorycard`;

CREATE TABLE `victorycard` (
  `VrCrdNr` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `cardnumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`VrCrdNr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `victorycard` */

insert  into `victorycard`(`VrCrdNr`,`value`,`cardnumber`) values 
(1,1,4),
(2,3,5),
(3,6,6),
(4,-1,7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
