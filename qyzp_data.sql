-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: qyzp_data
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `uname` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `email` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '邮箱',
  `tel` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '电话',
  `companyName` varchar(70) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名',
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司地址',
  `headPic` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司账户头像',
  `detail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '详细信息',
  `role_type` int(4) NOT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `company_uname_uindex` (`uname`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='公司';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (5,'123asd','321','123@qq.com','13456721','asdfas','asdsda',NULL,NULL,4),(6,'123asda','123','123123@qq.com','13456721','asdfas','asdsda',NULL,NULL,4);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位id',
  `jobName` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '岗位名称',
  `jobType` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '岗位类型',
  `company_id` int(11) NOT NULL COMMENT '公司id',
  `company_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名称',
  `company_address` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司地址',
  `recruitNumber` int(11) NOT NULL COMMENT '招聘人数',
  `educationRequire` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学历要求',
  `salary` int(11) NOT NULL COMMENT '薪资',
  `detail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='招聘';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'asad','IT',5,'asdfas','asdssa',2000,'大专',5000,'fasdsaas'),(2,'asdfgh','IT',5,'asdfas','asdsaa',1200,'sada',50050,'fasdsasss'),(3,'asdsas','Java',5,'asdfas','asdsa',100,'sad',5000,'fasdsa');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `resume` text COLLATE utf8_german2_ci NOT NULL COMMENT '简历JSON',
  `user_id` int(100) NOT NULL COMMENT '用户id',
  `resume_name` varchar(20) COLLATE utf8_german2_ci NOT NULL COMMENT '简历名',
  `base_path` varchar(100) COLLATE utf8_german2_ci DEFAULT NULL COMMENT '简历图片路径',
  `pic_path` varchar(100) COLLATE utf8_german2_ci DEFAULT NULL COMMENT '头像图片路径',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (2,'asdasdaaa',3333,'asdasd','asdasdasd','123123asdasads'),(3,'asdasd',3333,'asdasd','asdasdasd','123123asdasads'),(4,'jiji',5,'sss','s','s');
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume_sub`
--

DROP TABLE IF EXISTS `resume_sub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume_sub` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) COLLATE utf8_german2_ci NOT NULL COMMENT '姓名',
  `resume_id` int(100) NOT NULL COMMENT '用户名',
  `company` varchar(20) COLLATE utf8_german2_ci NOT NULL COMMENT '公司名',
  `title` varchar(50) COLLATE utf8_german2_ci NOT NULL COMMENT '标题',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume_sub`
--

LOCK TABLES `resume_sub` WRITE;
/*!40000 ALTER TABLE `resume_sub` DISABLE KEYS */;
/*!40000 ALTER TABLE `resume_sub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torecruit`
--

DROP TABLE IF EXISTS `torecruit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `torecruit` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户真名',
  `job_id` bigint(20) DEFAULT NULL COMMENT '岗位id',
  `job_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '岗位名称',
  `company_name` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司名称',
  `expectSalary` int(11) DEFAULT NULL COMMENT '期望薪资',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interview` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '面试通知',
  `company_id` int(11) DEFAULT NULL COMMENT '公司id',
  `resume_id` int(11) DEFAULT NULL COMMENT '简历id',
  `resume_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '简历名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='应聘';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torecruit`
--

LOCK TABLES `torecruit` WRITE;
/*!40000 ALTER TABLE `torecruit` DISABLE KEYS */;
INSERT INTO `torecruit` VALUES (12,'asd',1,'afsgassd','asdfasgh',5000,1,'y',5,2,'asd'),(12,'asd',1,NULL,'asdfas',5000,2,NULL,5,3,'asd');
/*!40000 ALTER TABLE `torecruit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `uname` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '邮件',
  `tel` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话',
  `willPosition` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '期待获得的职位',
  `role_type` int(4) NOT NULL COMMENT '角色类型',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `headPic` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头像路径',
  `detail` varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci DEFAULT NULL COMMENT '详细信息',
  `userName` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户真名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (12,'123asd','123','123@qq.com',NULL,NULL,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qyzp_data'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-08 23:50:01
