/*
Navicat MySQL Data Transfer

Source Server         : 10.0.193.245
Source Server Version : 50720
Source Host           : 10.0.193.245:3306
Source Database       : devtools

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-23 20:07:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for database_config
-- ----------------------------
DROP TABLE IF EXISTS `database_config`;
CREATE TABLE `database_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL COMMENT '数据库类型<>ORACLE=oracle=ORACLE&MYSQL=mysql=MYSQL',
  `url` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of database_config
-- ----------------------------
INSERT INTO `database_config` VALUES ('1', '33', 'oracle', 'jdbc:oracle:thin:@10.0.193.247:1521:ims', 'ims_tx', 'ims_tx');

-- ----------------------------
-- Table structure for event_bean
-- ----------------------------
DROP TABLE IF EXISTS `event_bean`;
CREATE TABLE `event_bean` (
  `id` int(11) NOT NULL,
  `class_name` varchar(200) DEFAULT NULL,
  `class_cn_name` varchar(200) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_bean
-- ----------------------------

-- ----------------------------
-- Table structure for event_field
-- ----------------------------
DROP TABLE IF EXISTS `event_field`;
CREATE TABLE `event_field` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `field_code` varchar(50) DEFAULT NULL COMMENT '字段CODE',
  `field_name` varchar(50) DEFAULT NULL COMMENT '字段名称',
  `field_type` varchar(20) DEFAULT NULL COMMENT '字段类型',
  `is_key` int(11) DEFAULT '0' COMMENT '是否主键<>Y=1=是&N=0=否',
  `is_null` int(11) DEFAULT '1' COMMENT '是否主键<>Y=1=是&N=0=否',
  `min_value` varchar(255) DEFAULT NULL,
  `max_vale` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_field
-- ----------------------------

-- ----------------------------
-- Table structure for gemfire_bean
-- ----------------------------
DROP TABLE IF EXISTS `gemfire_bean`;
CREATE TABLE `gemfire_bean` (
  `id` int(11) NOT NULL,
  `class_name` varchar(200) DEFAULT NULL,
  `class_cn_name` varchar(200) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gemfire_bean
-- ----------------------------

-- ----------------------------
-- Table structure for gemfire_field
-- ----------------------------
DROP TABLE IF EXISTS `gemfire_field`;
CREATE TABLE `gemfire_field` (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `field_code` varchar(50) DEFAULT NULL COMMENT '字段CODE',
  `field_name` varchar(50) DEFAULT NULL COMMENT '字段名称',
  `field_type` varchar(20) DEFAULT NULL COMMENT '字段类型',
  `is_key` int(11) DEFAULT '0' COMMENT '是否主键<>Y=1=是&N=0=否',
  `is_null` int(11) DEFAULT '1' COMMENT '是否主键<>Y=1=是&N=0=否',
  `min_value` varchar(255) DEFAULT NULL,
  `max_vale` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`,`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gemfire_field
-- ----------------------------
INSERT INTO `gemfire_field` VALUES ('0', '0', 'fdsf', 'dd', 'fdsfs', '0', '1', null, null, 'fds');
INSERT INTO `gemfire_field` VALUES ('2', '0', 'fdsf', 'dd', 'fdsfs', '0', '1', null, null, 'fds');
INSERT INTO `gemfire_field` VALUES ('3', '0', 'fdsf', 'dd', 'fdsfs', '0', '1', null, null, 'fds');
INSERT INTO `gemfire_field` VALUES ('4', '0', 'fdsf', 'dd', 'fdsfs', '0', '1', null, null, 'fds');
INSERT INTO `gemfire_field` VALUES ('5', '0', 'fdsf', 'dd', 'fdsfs', '0', '1', null, null, 'fds');

-- ----------------------------
-- Table structure for gemfire_index
-- ----------------------------
DROP TABLE IF EXISTS `gemfire_index`;
CREATE TABLE `gemfire_index` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gemfire_id` int(11) DEFAULT NULL,
  `field_code` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gemfire_index
-- ----------------------------
