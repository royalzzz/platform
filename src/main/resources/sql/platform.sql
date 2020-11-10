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

 Date: 09/11/2020 22:10:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for kbqa_sds_chemical
-- ----------------------------
DROP TABLE IF EXISTS `kbqa_sds_chemical`;
CREATE TABLE `kbqa_sds_chemical`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `MF` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `MW` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `UN` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `acuteToxicity` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `application` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `boilingPoint` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `carcinogenicity` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `cas` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `chemicalProperty` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `chineseName` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `combustionHeat` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `container` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `disposalMethods` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `englishName` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `environmentalHazards` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `explosionHazard` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `extinguishingAgent` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `eyeContact` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `eyeProtection` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `fireFightingMethods` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `flammabilityLevel` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `flashPoint` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `hazardCategory` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `healthHazard` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `healthHazardLevel` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `ignitionTemperature` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `ingestion` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `inhalationContact` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `invasionMethod` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `irritating` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `isolationAndEvacuationDistance` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `kow` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `lc50` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `ld50` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `leakControl` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `leakHandling` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `lel` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `mac` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `meltingPoint` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `modeOfTransport` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `mutagenicity` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `otherChineseName` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `otherEnglishName` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `otherProtection` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `otherToxicologicalEffects` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `packagingLogo` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `packingCategory` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `pc_stel` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `pc_twa` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `personalProtectionForEmergencyPersonnel` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `ph` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `productionMethod` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `productionProcessDangers` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `reactivityLevel` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `relativeDensity` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `respiratoryProtection` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `saturatedVaporPressure` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `sensitization` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `shape` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `skinContact` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `skinProtection` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `smell` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `solubility` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `specialHazard` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `subacuteAndChronicToxicity` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `taste` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `teratogenicity` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `threatenLifeImmediately` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `thresholdPressure` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `thresholdTemperature` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `tlv_stel` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `tlv_twa` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `transportationConsiderations` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `uel` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `vaporRelativeDensity` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
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
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'https://tse3-mm.cn.bing.net/th/id/OIP.emcIgfptf8eAAVy7_229MAHaHa?w=139&h=150&c=7&o=5&dpr=1.25&pid=1.7', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 10:46:27', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 10:46:27', 'royal', '山东省', '朱孟帅', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (2, 'https://tse4-mm.cn.bing.net/th/id/OIP.HAeSXQGT8wg5t_3GGYlmJwHaHa?w=170&h=180&c=7&o=5&dpr=1.25&pid=1.7', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 15:25:18', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 15:25:18', 'sjf', '山东省', '隋建飞', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (3, 'https://tse1-mm.cn.bing.net/th/id/OIP.lFC1WfEqTOnpifh-diCkjgAAAA?w=180&h=180&c=7&o=5&dpr=1.25&pid=1.7', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 15:25:18', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 15:25:18', 'yxl', '山东省', '岳小龙', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (4, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2650935025,2542230772&fm=11&gp=0.jpg', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 15:25:18', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 15:25:18', 'zsl', '山东省', '邹树林', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (5, 'https://tse4-mm.cn.bing.net/th/id/OIP.Spo5l-fTAwjt4ZSsAarM1gHaHa?w=150&h=150&c=7&o=5&dpr=1.25&pid=1.7', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 15:25:18', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 15:25:18', 'kitlee', '山东省', '李浩杰', 'e10adc3949ba59abbe56e057f20f883e');

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
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES (1, 'ALL', '所有权限');
INSERT INTO `user_authority` VALUES (2, 'READ_ONLY', '只读权限');
INSERT INTO `user_authority` VALUES (3, 'WRITE', '写入权限');

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_basic_info
-- ----------------------------
INSERT INTO `user_basic_info` VALUES (1, 'https://tse3-mm.cn.bing.net/th/id/OIP.emcIgfptf8eAAVy7_229MAHaHa?w=139&h=150&c=7&o=5&dpr=1.25&pid=1.7', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 10:46:27', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 10:46:27', 'royal', '山东省', '朱孟帅');
INSERT INTO `user_basic_info` VALUES (2, 'https://tse4-mm.cn.bing.net/th/id/OIP.HAeSXQGT8wg5t_3GGYlmJwHaHa?w=170&h=180&c=7&o=5&dpr=1.25&pid=1.7', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 15:25:18', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 15:25:18', 'sjf', '山东省', '隋建飞');
INSERT INTO `user_basic_info` VALUES (3, 'https://tse1-mm.cn.bing.net/th/id/OIP.lFC1WfEqTOnpifh-diCkjgAAAA?w=180&h=180&c=7&o=5&dpr=1.25&pid=1.7', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 15:25:18', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 15:25:18', 'yxl', '山东省', '岳小龙');
INSERT INTO `user_basic_info` VALUES (4, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2650935025,2542230772&fm=11&gp=0.jpg', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 15:25:18', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 15:25:18', 'zsl', '山东省', '邹树林');
INSERT INTO `user_basic_info` VALUES (5, 'https://tse4-mm.cn.bing.net/th/id/OIP.Spo5l-fTAwjt4ZSsAarM1gHaHa?w=150&h=150&c=7&o=5&dpr=1.25&pid=1.7', '1995-11-23 08:00:00', '青岛市', '中国', '2020-10-26 15:25:18', '824259085@qq.com', 1, '该人很懒...', '2020-10-26 15:25:18', 'kitlee', '山东省', '李浩杰');

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
-- Records of user_email_login
-- ----------------------------
INSERT INTO `user_email_login` VALUES (1, b'0', b'0', '2020-10-26 10:46:27', b'0', '824259085@qq.com', b'0', '2020-10-26 10:46:27', '$2a$10$OZz3ASryzCYBovMHjYuQROuMnzhbm8YwHGFBK5NQ1oQqh6vvWI.bK');

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
-- Records of user_has_role
-- ----------------------------
INSERT INTO `user_has_role` VALUES (1, 1);
INSERT INTO `user_has_role` VALUES (2, 1);
INSERT INTO `user_has_role` VALUES (3, 1);
INSERT INTO `user_has_role` VALUES (4, 1);
INSERT INTO `user_has_role` VALUES (5, 1);
INSERT INTO `user_has_role` VALUES (1, 2);
INSERT INTO `user_has_role` VALUES (2, 2);
INSERT INTO `user_has_role` VALUES (3, 2);
INSERT INTO `user_has_role` VALUES (4, 2);
INSERT INTO `user_has_role` VALUES (5, 2);

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
-- Records of user_name_login
-- ----------------------------
INSERT INTO `user_name_login` VALUES (1, b'1', b'1', b'1', b'1', '$2a$10$qpoohx0hSZuIPKFlaiBDVOXlD.3MGi1oMrniGHc26PRT9oThGIf.W', 'royal');
INSERT INTO `user_name_login` VALUES (2, b'1', b'1', b'1', b'1', '$2a$10$qpoohx0hSZuIPKFlaiBDVOXlD.3MGi1oMrniGHc26PRT9oThGIf.W', 'sjf');
INSERT INTO `user_name_login` VALUES (3, b'1', b'1', b'1', b'1', '$2a$10$qpoohx0hSZuIPKFlaiBDVOXlD.3MGi1oMrniGHc26PRT9oThGIf.W', 'yxl');
INSERT INTO `user_name_login` VALUES (4, b'1', b'1', b'1', b'1', '$2a$10$qpoohx0hSZuIPKFlaiBDVOXlD.3MGi1oMrniGHc26PRT9oThGIf.W', 'zsl');
INSERT INTO `user_name_login` VALUES (5, b'1', b'1', b'1', b'1', '$2a$10$qpoohx0hSZuIPKFlaiBDVOXlD.3MGi1oMrniGHc26PRT9oThGIf.W', 'kitlee');

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
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 'ADMIN', '管理员');
INSERT INTO `user_role` VALUES (2, 'USER', '普通用户');

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
-- Records of user_role_has_authority
-- ----------------------------
INSERT INTO `user_role_has_authority` VALUES (1, 1);
INSERT INTO `user_role_has_authority` VALUES (1, 2);
INSERT INTO `user_role_has_authority` VALUES (2, 2);
INSERT INTO `user_role_has_authority` VALUES (1, 3);

SET FOREIGN_KEY_CHECKS = 1;
