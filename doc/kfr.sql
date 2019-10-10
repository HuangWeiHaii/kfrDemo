/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.17 : Database - kfr
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kfr` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `kfr`;

/*Table structure for table `kfr_maindata` */

DROP TABLE IF EXISTS `kfr_maindata`;

CREATE TABLE `kfr_maindata` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `availableQuota` double DEFAULT NULL,
  `availableBalance` double DEFAULT NULL,
  `pool` double DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `kfr_maindata` */

insert  into `kfr_maindata`(`mid`,`availableQuota`,`availableBalance`,`pool`,`uid`) values (1,1000,11.976016,1988.023984,1),(2,23423,42318.646,2318.354,2);

/*Table structure for table `kfr_order` */

DROP TABLE IF EXISTS `kfr_order`;

CREATE TABLE `kfr_order` (
  `order_id` varchar(64) NOT NULL,
  `coin_number` int(5) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `order_status` int(2) DEFAULT '0' COMMENT '0表示未完成的订单',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `kfr_order` */

insert  into `kfr_order`(`order_id`,`coin_number`,`totalPrice`,`price`,`buyer_id`,`seller_id`,`order_status`,`create_time`,`update_time`) values ('5cd4b374',1011,5055,5,1,2,1,'2019-10-02 15:50:41','2019-10-02 15:50:48');
insert  into `kfr_order`(`order_id`,`coin_number`,`totalPrice`,`price`,`buyer_id`,`seller_id`,`order_status`,`create_time`,`update_time`) values ('5d4b37d4',1011,5055,5,1,2,1,'2019-10-02 15:50:41','2019-10-02 15:50:48');

/*Table structure for table `kfr_user` */

DROP TABLE IF EXISTS `kfr_user`;

CREATE TABLE `kfr_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nikeName` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `idcard` varchar(18) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `superiors_id` int(11) DEFAULT NULL,
  `certifiedStatus` int(2) DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `kfr_user` */

insert  into `kfr_user`(`id`,`nikeName`,`username`,`password`,`idcard`,`phone`,`superiors_id`,`certifiedStatus`,`create_time`,`update_time`) values (1,'黄威海','13313767166','123','350521199810260518','13313767166',NULL,1,'2019-10-02 15:51:54','2019-10-02 15:52:03'),(2,'张三','13313767222','123','350521199810260222','13313767222',1,1,'2019-10-02 15:51:54','2019-10-02 15:52:03'),(3,'李四','q1234','1234','350521199810260514','13311767166',NULL,0,'2019-10-02 16:05:00','2019-10-02 16:05:00'),(4,'王五','13311167222','1223','350521199310260514','13311727166',NULL,1,'2019-10-02 16:06:39','2019-10-02 16:24:58');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
