/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : platform

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 02/12/2020 20:14:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for event_accident_report
-- ----------------------------
DROP TABLE IF EXISTS `event_accident_report`;
CREATE TABLE `event_accident_report`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 166 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for event_biaozhu_pair
-- ----------------------------
DROP TABLE IF EXISTS `event_biaozhu_pair`;
CREATE TABLE `event_biaozhu_pair`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anli` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `biaozhun` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `source` bigint(255) NULL DEFAULT NULL,
  `sourceid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for event_edge
-- ----------------------------
DROP TABLE IF EXISTS `event_edge`;
CREATE TABLE `event_edge`  (
  `id` bigint(20) NULL DEFAULT NULL,
  `fromNode` bigint(20) NULL DEFAULT NULL,
  `toNode` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for event_node
-- ----------------------------
DROP TABLE IF EXISTS `event_node`;
CREATE TABLE `event_node`  (
  `id` bigint(20) NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for event_node_biaozhupair
-- ----------------------------
DROP TABLE IF EXISTS `event_node_biaozhupair`;
CREATE TABLE `event_node_biaozhupair`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `biaozhutext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `node` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nodeid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for event_tft_table
-- ----------------------------
DROP TABLE IF EXISTS `event_tft_table`;
CREATE TABLE `event_tft_table`  (
  `_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `_data` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `_events` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kbqa_sds_chemical
-- ----------------------------
DROP TABLE IF EXISTS `kbqa_sds_chemical`;
CREATE TABLE `kbqa_sds_chemical`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `MF` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `MW` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `UN` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `acuteToxicity` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `application` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `boilingPoint` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `carcinogenicity` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `cas` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `chemicalProperty` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `chineseName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `combustionHeat` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `container` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `disposalMethods` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `englishName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `environmentalHazards` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `explosionHazard` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `extinguishingAgent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `eyeContact` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `eyeProtection` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `fireFightingMethods` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `flammabilityLevel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `flashPoint` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `hazardCategory` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `healthHazard` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `healthHazardLevel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `ignitionTemperature` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `ingestion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `inhalationContact` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `invasionMethod` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `irritating` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `isolationAndEvacuationDistance` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `kow` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `lc50` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `ld50` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `leakControl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `leakHandling` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `lel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `mac` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `meltingPoint` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `modeOfTransport` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `mutagenicity` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `otherChineseName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `otherEnglishName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `otherProtection` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `otherToxicologicalEffects` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `packagingLogo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `packingCategory` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `pc_stel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `pc_twa` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `personalProtectionForEmergencyPersonnel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `ph` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `productionMethod` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `productionProcessDangers` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `reactivityLevel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `relativeDensity` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `respiratoryProtection` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `saturatedVaporPressure` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `sensitization` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `shape` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `skinContact` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `skinProtection` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `smell` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `solubility` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `specialHazard` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `subacuteAndChronicToxicity` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `taste` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `teratogenicity` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `threatenLifeImmediately` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `thresholdPressure` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `thresholdTemperature` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `tlv_stel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `tlv_twa` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `transportationConsiderations` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `uel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `vaporRelativeDensity` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3018 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `yuqing_crawler_keywords` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `yuqing_crawler_start_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `yuqing_crawler_time_split` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_authority
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority`  (
  `authorityId` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorityName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authorityId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `user_basic_info`;
CREATE TABLE `user_basic_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `modifiedTime` datetime(0) NULL DEFAULT NULL,
  `nickName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_basic_info_copy1
-- ----------------------------
DROP TABLE IF EXISTS `user_basic_info_copy1`;
CREATE TABLE `user_basic_info_copy1`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `modifiedTime` datetime(0) NULL DEFAULT NULL,
  `nickName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_email_login
-- ----------------------------
DROP TABLE IF EXISTS `user_email_login`;
CREATE TABLE `user_email_login`  (
  `userId` bigint(20) NOT NULL,
  `accountNonExpired` bit(1) NOT NULL,
  `accountNonLocked` bit(1) NOT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `credentialsNonExpired` bit(1) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `modifiedTime` datetime(0) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_has_role
-- ----------------------------
DROP TABLE IF EXISTS `user_has_role`;
CREATE TABLE `user_has_role`  (
  `_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`_id`, `role_id`) USING BTREE,
  INDEX `FK7xjnmxlbbtifvlxu0cmhavsne`(`role_id`) USING BTREE,
  CONSTRAINT `FK7xjnmxlbbtifvlxu0cmhavsne` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKtjyupacw27pqefbu5xtvuajhg` FOREIGN KEY (`_id`) REFERENCES `user_basic_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_has_role_copy1
-- ----------------------------
DROP TABLE IF EXISTS `user_has_role_copy1`;
CREATE TABLE `user_has_role_copy1`  (
  `_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`_id`, `role_id`) USING BTREE,
  INDEX `FK7xjnmxlbbtifvlxu0cmhavsne`(`role_id`) USING BTREE,
  CONSTRAINT `user_has_role_copy1_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_has_role_copy1_ibfk_2` FOREIGN KEY (`_id`) REFERENCES `user_basic_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_name_login
-- ----------------------------
DROP TABLE IF EXISTS `user_name_login`;
CREATE TABLE `user_name_login`  (
  `userId` bigint(20) NOT NULL,
  `accountNonExpired` bit(1) NOT NULL,
  `accountNonLocked` bit(1) NOT NULL,
  `credentialsNonExpired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_name_login_copy1
-- ----------------------------
DROP TABLE IF EXISTS `user_name_login_copy1`;
CREATE TABLE `user_name_login_copy1`  (
  `userId` bigint(20) NOT NULL,
  `accountNonExpired` bit(1) NOT NULL,
  `accountNonLocked` bit(1) NOT NULL,
  `credentialsNonExpired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `roleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `roleName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role_has_authority
-- ----------------------------
DROP TABLE IF EXISTS `user_role_has_authority`;
CREATE TABLE `user_role_has_authority`  (
  `role_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`, `authority_id`) USING BTREE,
  INDEX `FKoiu4g9cd10h1s081dorwdriek`(`authority_id`) USING BTREE,
  CONSTRAINT `FK67lyhw9h6mtoc5odxycawk92r` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKoiu4g9cd10h1s081dorwdriek` FOREIGN KEY (`authority_id`) REFERENCES `user_authority` (`authorityId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yuqing_originnews
-- ----------------------------
DROP TABLE IF EXISTS `yuqing_originnews`;
CREATE TABLE `yuqing_originnews`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `news_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `news_author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `news_timeStamp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `news_comments_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `news_comments` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `news_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `origin_weibo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `news_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `exception` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 240 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
