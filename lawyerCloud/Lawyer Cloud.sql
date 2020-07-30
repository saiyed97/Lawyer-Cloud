/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.0.27-community-nt : Database - lawyer_cloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lawyer_cloud` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lawyer_cloud`;

/*Table structure for table `area_tbl` */

DROP TABLE IF EXISTS `area_tbl`;

CREATE TABLE `area_tbl` (
  `AreaId` int(11) NOT NULL,
  `AreaName` varchar(255) default NULL,
  `cityId` int(11) default NULL,
  `stateId` int(11) default NULL,
  PRIMARY KEY  (`AreaId`),
  KEY `FKCB6AA90CFD50CA21` (`stateId`),
  KEY `FKCB6AA90C8619A21F` (`cityId`),
  CONSTRAINT `FKCB6AA90C8619A21F` FOREIGN KEY (`cityId`) REFERENCES `city_tbl` (`CityId`),
  CONSTRAINT `FKCB6AA90CFD50CA21` FOREIGN KEY (`stateId`) REFERENCES `state_tbl` (`StateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `area_tbl` */

insert  into `area_tbl`(`AreaId`,`AreaName`,`cityId`,`stateId`) values (1,'Downtown',2,10),(2,'South',2,10),(3,'North',2,10),(4,'East',2,10),(5,'Downtown',7,7),(6,'Northern',23,4),(7,'Western',21,6),(8,'Albert St',18,2);

/*Table structure for table `category_tbl` */

DROP TABLE IF EXISTS `category_tbl`;

CREATE TABLE `category_tbl` (
  `CategoryId` int(11) NOT NULL,
  `CategoryName` varchar(255) default NULL,
  PRIMARY KEY  (`CategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category_tbl` */

insert  into `category_tbl`(`CategoryId`,`CategoryName`) values (1,'Criminal'),(2,'Divorce'),(3,'Industrial'),(4,'Corporate'),(5,'Financial'),(6,'Accident'),(7,'Labour'),(8,'Land'),(9,'Family'),(10,'Service');

/*Table structure for table `city_tbl` */

DROP TABLE IF EXISTS `city_tbl`;

CREATE TABLE `city_tbl` (
  `CityId` int(11) NOT NULL,
  `CityName` varchar(255) default NULL,
  `stateId` int(11) default NULL,
  PRIMARY KEY  (`CityId`),
  KEY `FKAB4ADAEAFD50CA21` (`stateId`),
  CONSTRAINT `FKAB4ADAEAFD50CA21` FOREIGN KEY (`stateId`) REFERENCES `state_tbl` (`StateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `city_tbl` */

insert  into `city_tbl`(`CityId`,`CityName`,`stateId`) values (1,'Saskatoon',10),(2,'Regina',10),(3,'Prince Albert',10),(4,'Moose Jaw',10),(5,'Swift Current',10),(6,'Yorkton',10),(7,'Toronto',7),(8,'Toronto Main City',7),(9,'Ottawa',7),(10,'Hamilton',7),(11,'Windsor',7),(12,'London',7),(13,'Kingston',7),(14,'Calgary',1),(15,'Edmonton',1),(16,'St. Albert',1),(17,'Vancouver',2),(18,'Victoria',2),(19,'Winnipeg',3),(20,'Brandon',3),(21,'Halifax',6),(22,'Montreal',9),(23,'Dieppe',4),(24,'Winkler',3);

/*Table structure for table `clientregister_tbl` */

DROP TABLE IF EXISTS `clientregister_tbl`;

CREATE TABLE `clientregister_tbl` (
  `ClientRegisterId` int(11) NOT NULL,
  `FirstName` varchar(255) default NULL,
  `LastName` varchar(255) default NULL,
  `MobileNumber` varchar(255) default NULL,
  `stateId` int(11) default NULL,
  `cityId` int(11) default NULL,
  `areaId` int(11) default NULL,
  `Address` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  `FileName` varchar(255) default NULL,
  `FilePath` varchar(255) default NULL,
  PRIMARY KEY  (`ClientRegisterId`),
  KEY `FKC92B038D80358F63` (`areaId`),
  KEY `FKC92B038D84873D1` (`loginId`),
  KEY `FKC92B038DFD50CA21` (`stateId`),
  KEY `FKC92B038D8619A21F` (`cityId`),
  CONSTRAINT `FKC92B038D80358F63` FOREIGN KEY (`areaId`) REFERENCES `area_tbl` (`AreaId`),
  CONSTRAINT `FKC92B038D84873D1` FOREIGN KEY (`loginId`) REFERENCES `login_tbl` (`LoginId`),
  CONSTRAINT `FKC92B038D8619A21F` FOREIGN KEY (`cityId`) REFERENCES `city_tbl` (`CityId`),
  CONSTRAINT `FKC92B038DFD50CA21` FOREIGN KEY (`stateId`) REFERENCES `state_tbl` (`StateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clientregister_tbl` */

insert  into `clientregister_tbl`(`ClientRegisterId`,`FirstName`,`LastName`,`MobileNumber`,`stateId`,`cityId`,`areaId`,`Address`,`loginId`,`FileName`,`FilePath`) values (1,'Faizan','Saiyed','6399974786',10,2,4,'14th Ave Victoria',2,'1490021605681.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\'),(2,'Darek','Froambach','0123456789',10,2,2,'505 munro pl',7,'index.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\'),(3,'Racheal','Christian','1234567890',10,2,3,'3939 rochdale blvd',8,'index2.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\'),(4,'Kia','Martyn','6393063067',6,21,7,'Pakwa Tower',10,'index1.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\');

/*Table structure for table `complain_tbl` */

DROP TABLE IF EXISTS `complain_tbl`;

CREATE TABLE `complain_tbl` (
  `ComplainId` int(11) NOT NULL,
  `Name` varchar(255) default NULL,
  `ComplainSubject` varchar(255) default NULL,
  `ComplainDescription` varchar(255) default NULL,
  `ComplainDateAndTime` varchar(255) default NULL,
  `ComplainStatus` varchar(255) default NULL,
  `ReplyDescription` varchar(255) default NULL,
  `complainFrom` int(11) default NULL,
  `complainTo` int(11) default NULL,
  `ToName` varchar(255) default NULL,
  PRIMARY KEY  (`ComplainId`),
  KEY `FK1B57368D36146B1` (`complainTo`),
  KEY `FK1B57368F59949A0` (`complainFrom`),
  CONSTRAINT `FK1B57368D36146B1` FOREIGN KEY (`complainTo`) REFERENCES `login_tbl` (`LoginId`),
  CONSTRAINT `FK1B57368F59949A0` FOREIGN KEY (`complainFrom`) REFERENCES `login_tbl` (`LoginId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `complain_tbl` */

/*Table structure for table `contactus_tbl` */

DROP TABLE IF EXISTS `contactus_tbl`;

CREATE TABLE `contactus_tbl` (
  `ContactUsId` int(11) NOT NULL,
  `Name` varchar(255) default NULL,
  `Email` varchar(255) default NULL,
  `MobileNumber` varchar(255) default NULL,
  `categoryId` int(11) default NULL,
  `Description` varchar(255) default NULL,
  PRIMARY KEY  (`ContactUsId`),
  KEY `FK5EBC0ABD524F3545` (`categoryId`),
  CONSTRAINT `FK5EBC0ABD524F3545` FOREIGN KEY (`categoryId`) REFERENCES `category_tbl` (`CategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contactus_tbl` */

insert  into `contactus_tbl`(`ContactUsId`,`Name`,`Email`,`MobileNumber`,`categoryId`,`Description`) values (1,'Faizan','mohd.faizan1505@gmail.com','3067867861',1,'I need an immediate assistance.');

/*Table structure for table `feedback_tbl` */

DROP TABLE IF EXISTS `feedback_tbl`;

CREATE TABLE `feedback_tbl` (
  `FeedbackId` int(11) NOT NULL,
  `Name` varchar(255) default NULL,
  `FeedbackSubject` varchar(255) default NULL,
  `FeedbackDescription` varchar(255) default NULL,
  `FeedbackDateAndTime` varchar(255) default NULL,
  `feedbackFrom` int(11) default NULL,
  `feedbackTo` int(11) default NULL,
  `ToName` varchar(255) default NULL,
  PRIMARY KEY  (`FeedbackId`),
  KEY `FK992790048D0B663C` (`feedbackFrom`),
  KEY `FK992790041AA9DA4D` (`feedbackTo`),
  CONSTRAINT `FK992790041AA9DA4D` FOREIGN KEY (`feedbackTo`) REFERENCES `login_tbl` (`LoginId`),
  CONSTRAINT `FK992790048D0B663C` FOREIGN KEY (`feedbackFrom`) REFERENCES `login_tbl` (`LoginId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `feedback_tbl` */

/*Table structure for table `lawyerregister_tbl` */

DROP TABLE IF EXISTS `lawyerregister_tbl`;

CREATE TABLE `lawyerregister_tbl` (
  `LawyerRegisterId` int(11) NOT NULL,
  `FirstName` varchar(255) default NULL,
  `LastName` varchar(255) default NULL,
  `MobileNumber` varchar(255) default NULL,
  `FileName` varchar(255) default NULL,
  `FilePath` varchar(255) default NULL,
  `stateId` int(11) default NULL,
  `cityId` int(11) default NULL,
  `areaId` int(11) default NULL,
  `Address` varchar(255) default NULL,
  `categoryId` int(11) default NULL,
  `subCategoryId` int(11) default NULL,
  `Experience` varchar(255) default NULL,
  `Qualification` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  PRIMARY KEY  (`LawyerRegisterId`),
  KEY `FKC84BB84680358F63` (`areaId`),
  KEY `FKC84BB84684873D1` (`loginId`),
  KEY `FKC84BB846FD50CA21` (`stateId`),
  KEY `FKC84BB846A9C278DB` (`subCategoryId`),
  KEY `FKC84BB8468619A21F` (`cityId`),
  KEY `FKC84BB846524F3545` (`categoryId`),
  CONSTRAINT `FKC84BB846524F3545` FOREIGN KEY (`categoryId`) REFERENCES `category_tbl` (`CategoryId`),
  CONSTRAINT `FKC84BB84680358F63` FOREIGN KEY (`areaId`) REFERENCES `area_tbl` (`AreaId`),
  CONSTRAINT `FKC84BB84684873D1` FOREIGN KEY (`loginId`) REFERENCES `login_tbl` (`LoginId`),
  CONSTRAINT `FKC84BB8468619A21F` FOREIGN KEY (`cityId`) REFERENCES `city_tbl` (`CityId`),
  CONSTRAINT `FKC84BB846A9C278DB` FOREIGN KEY (`subCategoryId`) REFERENCES `subcategory_tbl` (`SubCategoryId`),
  CONSTRAINT `FKC84BB846FD50CA21` FOREIGN KEY (`stateId`) REFERENCES `state_tbl` (`StateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `lawyerregister_tbl` */

insert  into `lawyerregister_tbl`(`LawyerRegisterId`,`FirstName`,`LastName`,`MobileNumber`,`FileName`,`FilePath`,`stateId`,`cityId`,`areaId`,`Address`,`categoryId`,`subCategoryId`,`Experience`,`Qualification`,`loginId`) values (1,'Tauheed','Maniar','3067867860','Desert.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\',10,2,2,'Rae St',1,32,'5','LLM',3),(2,'Nadeem','Sultan','3067867867','Lighthouse.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\',7,7,5,'201 Broad St',9,5,'20','LLB, LLM',4),(3,'Ricardo','Loyola','3067777777','Penguins.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\',10,2,2,'43 Munroe pl',2,20,'3','LLB',5),(4,'Mohammed','Saiyed','3067878799','Chrysanthemum.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\',10,2,3,'Rochdale Blvd.',6,28,'5','LLM, LLB',6),(5,'Christine','George','6399987876','index4.jpg','C:\\Users\\SAIYED\\LawyerCloud\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lawyerCloud\\doc\\',4,23,6,'303 Montreal St',5,27,'3','LLB',9);

/*Table structure for table `login_tbl` */

DROP TABLE IF EXISTS `login_tbl`;

CREATE TABLE `login_tbl` (
  `LoginId` int(11) NOT NULL,
  `EmailAdderss` varchar(255) default NULL,
  `Password` varchar(255) default NULL,
  `Role` varchar(255) default NULL,
  PRIMARY KEY  (`LoginId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login_tbl` */

insert  into `login_tbl`(`LoginId`,`EmailAdderss`,`Password`,`Role`) values (1,'lawyercloud10298@gmail.com','lawyercloud@10298','admin'),(2,'mohd.faizan1505@gmail.com','faizansaiyed','Client'),(3,'tauheedmaniar54@gmail.com','tauheedmaniar','Lawyer'),(4,'nadeemsultanahmad@gmail.com','nadeemsultan','Lawyer'),(5,'ricardoloyola@gmail.com','ricardoloyola','Lawyer'),(6,'mohd.faizan1511@gmail.com','mohammedsaiyed','Lawyer'),(7,'darekfroambach@gmail.com','darekfroambach','Client'),(8,'rachealchristian@gmail.com','rachealchristian','Client'),(9,'christinegeorge@gmail.com','christinegeorge','Lawyer'),(10,'kiamartyn@gmail.com','kiamartyn','Client');

/*Table structure for table `requestlawyer_tbl` */

DROP TABLE IF EXISTS `requestlawyer_tbl`;

CREATE TABLE `requestlawyer_tbl` (
  `RequestLawyerId` int(11) NOT NULL,
  `lawyerId` int(11) default NULL,
  `ClientId` int(11) default NULL,
  `categoryId` int(11) default NULL,
  `ClientContactNumber` varchar(255) default NULL,
  `RequestDescription` varchar(255) default NULL,
  `RequestDateAndTime` varchar(255) default NULL,
  `RequestStatus` varchar(255) default NULL,
  `RequestReplyDescription` varchar(255) default NULL,
  PRIMARY KEY  (`RequestLawyerId`),
  KEY `FK858EAAF22A05E7B3` (`ClientId`),
  KEY `FK858EAAF2AAF1294` (`lawyerId`),
  KEY `FK858EAAF2524F3545` (`categoryId`),
  CONSTRAINT `FK858EAAF22A05E7B3` FOREIGN KEY (`ClientId`) REFERENCES `login_tbl` (`LoginId`),
  CONSTRAINT `FK858EAAF2524F3545` FOREIGN KEY (`categoryId`) REFERENCES `category_tbl` (`CategoryId`),
  CONSTRAINT `FK858EAAF2AAF1294` FOREIGN KEY (`lawyerId`) REFERENCES `lawyerregister_tbl` (`LawyerRegisterId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `requestlawyer_tbl` */

insert  into `requestlawyer_tbl`(`RequestLawyerId`,`lawyerId`,`ClientId`,`categoryId`,`ClientContactNumber`,`RequestDescription`,`RequestDateAndTime`,`RequestStatus`,`RequestReplyDescription`) values (1,1,2,1,'3067867860','I need immediate assistance for my murder case, can you please fix an appointment for me.','Mon Jul 13 20:35:11 CST 2020','Accepted','You can find my details, come to my address tomorrow noon'),(2,4,2,6,'6390909878','I am requesting you','Thu Jul 16 19:16:30 CST 2020','Pending',NULL),(3,3,2,2,'1234567890','T','Mon Jul 20 18:08:25 CST 2020','Accepted','Q'),(4,2,7,9,'0123456789','I have a query, if you can book me an appointment','Wed Jul 29 14:49:48 CST 2020','Pending',NULL),(5,4,2,6,'3067687867','Can you give me brief description about one of my cases which we talked in the last appointment','Wed Jul 29 14:56:17 CST 2020','Pending',NULL),(6,5,10,5,'1234567890','Can you reply me on my email coz I need immediate assistance','Wed Jul 29 15:18:40 CST 2020','Pending',NULL),(7,3,2,2,'6399987876','Here I have attached my office number, please contact me ASAP','Wed Jul 29 15:22:21 CST 2020','Pending',NULL),(8,3,7,2,'6399987678','Can I get your time to discuss some issues on going with my case','Wed Jul 29 15:24:18 CST 2020','Pending',NULL);

/*Table structure for table `state_tbl` */

DROP TABLE IF EXISTS `state_tbl`;

CREATE TABLE `state_tbl` (
  `StateId` int(11) NOT NULL,
  `StateName` varchar(255) default NULL,
  PRIMARY KEY  (`StateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `state_tbl` */

insert  into `state_tbl`(`StateId`,`StateName`) values (1,'Alberta'),(2,'British Columbia'),(3,'Manitoba'),(4,'New Brunswick'),(5,'Newfoundland and Labrador'),(6,'Nova Scotia'),(7,'Ontario'),(8,'Prince Edward Island'),(9,'Quebec'),(10,'Saskatchewan');

/*Table structure for table `subcategory_tbl` */

DROP TABLE IF EXISTS `subcategory_tbl`;

CREATE TABLE `subcategory_tbl` (
  `SubCategoryId` int(11) NOT NULL,
  `SubCategoryName` varchar(255) default NULL,
  `categoryId` int(11) default NULL,
  PRIMARY KEY  (`SubCategoryId`),
  KEY `FK94EAF5D524F3545` (`categoryId`),
  CONSTRAINT `FK94EAF5D524F3545` FOREIGN KEY (`categoryId`) REFERENCES `category_tbl` (`CategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `subcategory_tbl` */

insert  into `subcategory_tbl`(`SubCategoryId`,`SubCategoryName`,`categoryId`) values (4,'Loot',1),(5,'Divorce',9),(6,'Child Custody',9),(7,'Bonus',7),(8,'Trade Union',7),(9,'Condition of Service',7),(10,'Land Acquistion',8),(11,'Acquisition for defence purpose',8),(12,'Transfer of Land',8),(13,'Agricultural Land Ceiling',8),(14,'Retiral Benefits',10),(15,'Suspension',10),(16,'Promotion',10),(17,'Temporary Appointments',10),(18,'No Fault Divorce',2),(19,'Matrimonial Causes Act',2),(20,'Legal Seperation',2),(21,'Child Labour',3),(22,'Caste Disabilities',3),(23,'Cooperative',4),(24,'Family Owned Business',4),(25,'Public Sector Undertaking',4),(26,'Budget Management',5),(27,'Contract Act',5),(28,'General Damages',6),(29,'Medication',6),(30,'Cost of Rehabilitation',6),(31,'Sexual Harrasment',1),(32,'Murder',1),(33,'Robbery',1),(34,'Bank Scams',1),(35,'Kidnapping',1);

/*Table structure for table `testimonial_tbl` */

DROP TABLE IF EXISTS `testimonial_tbl`;

CREATE TABLE `testimonial_tbl` (
  `TestimonialId` int(11) NOT NULL,
  `testimonialDescription` varchar(255) default NULL,
  `TestimonialDateAndTime` varchar(255) default NULL,
  `TestimonialStatus` varchar(255) default NULL,
  `Name` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  PRIMARY KEY  (`TestimonialId`),
  KEY `FKD4DAAC1E84873D1` (`loginId`),
  CONSTRAINT `FKD4DAAC1E84873D1` FOREIGN KEY (`loginId`) REFERENCES `login_tbl` (`LoginId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `testimonial_tbl` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
