DROP 'demoapp'
CREATE DATABASE  IF NOT EXISTS `demoapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `demoapp`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'Rohit Agarwal','agarwal.ro@husky.neu.edu','qq'), (2,'Deepak Kannan','deepak.kannan@tcs.com','test');
UNLOCK TABLES;

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `paymentID` bigint(20) NOT NULL AUTO_INCREMENT,
  `cardHolderName` varchar(255) DEFAULT NULL,
  `cardNo` varchar(255) DEFAULT NULL,
  `cvv` varchar(255) DEFAULT NULL,
  `expiryDate` varchar(255) DEFAULT NULL,
  `userID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`paymentID`),
  UNIQUE KEY `paymentID` (`paymentID`),
  KEY `FK3454C9E6D3864E26` (`userID`),
  CONSTRAINT `FK3454C9E6D3864E26` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `payment` WRITE;
INSERT INTO `payment` VALUES (1,'Rohit Agarwal','6011859626355262','222','Rohit Agarwal',1),(2,'Rohit Agarwal','6011896526355124','123','Rohit Agarwal',1),(3,'Rohit Agarwal','6011896526355124','222','Rohit Agarwal',1);
UNLOCK TABLES;

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `RegistrationNo` bigint(20) NOT NULL AUTO_INCREMENT,
  `DailyRate` varchar(255) DEFAULT NULL,
  `HWRefNumber` varchar(255) DEFAULT NULL,
  `RentalDays` varchar(255) DEFAULT NULL,
  `TaxesAndFees` varchar(255) DEFAULT NULL,
  `TotalPrice` varchar(255) DEFAULT NULL,
  `TypicalSeating` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RegistrationNo`),
  UNIQUE KEY `RegistrationNo` (`RegistrationNo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `car` WRITE;
INSERT INTO `car` VALUES (1,'81.01/','3208955062','1/','27.48','108.49/','5','Hyundai','Compact'),(2,'36.99/','3269524402','1/','30.05','67.04/','5','Hyundai','Compact'),(3,'81.01/','4105543194','1/','27.48','108.49/','5','Hyundai','Compact');
UNLOCK TABLES;

DROP TABLE IF EXISTS `bookingdetails`;
CREATE TABLE `bookingdetails` (
  `bookingID` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookingDate` datetime DEFAULT NULL,
  `bookingTime` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `expiryDate` datetime DEFAULT NULL,
  `expiryTime` varchar(255) DEFAULT NULL,
  `sourceLocation` varchar(255) DEFAULT NULL,
  `carID` bigint(20) DEFAULT NULL,
  `paymentID` bigint(20) DEFAULT NULL,
  `userID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  UNIQUE KEY `bookingID` (`bookingID`),
  KEY `FKAACCE7C91A39EF52` (`paymentID`),
  KEY `FKAACCE7C9D3864E26` (`userID`),
  KEY `FKAACCE7C95CCDCEE` (`carID`),
  CONSTRAINT `FKAACCE7C91A39EF52` FOREIGN KEY (`paymentID`) REFERENCES `payment` (`paymentID`),
  CONSTRAINT `FKAACCE7C95CCDCEE` FOREIGN KEY (`carID`) REFERENCES `car` (`RegistrationNo`),
  CONSTRAINT `FKAACCE7C9D3864E26` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `bookingdetails` WRITE;
INSERT INTO `bookingdetails` VALUES (3,'2016-04-27 00:00:00','12:00','LGA','2016-04-28 00:00:00','12:00','LGA',3,3,NULL);
UNLOCK TABLES;
