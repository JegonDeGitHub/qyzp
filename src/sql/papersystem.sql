SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `Paper`
-- ----------------------------
DROP TABLE IF EXISTS `Paper`;
CREATE TABLE `Paper` (
  `Paper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PaperID',
  `name` varchar(100) NOT NULL COMMENT 'Paper名称',
  `number` int(11) NOT NULL COMMENT 'Paper数量',
  `detail` varchar(200) NOT NULL COMMENT 'Paper描述',
  PRIMARY KEY (`Paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='Paper表';

-- ----------------------------
-- Records of Paper
-- ----------------------------
INSERT INTO `Paper` VALUES ('1', '机器学习', '2', 'mlmlmlml');
INSERT INTO `Paper` VALUES ('2', '深度学习', '3', 'dldldl');
INSERT INTO `Paper` VALUES ('3', '大数据', '4', 'bdbdbd');