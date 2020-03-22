/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 100411
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 100411
 File Encoding         : 65001

 Date: 22/03/2020 20:42:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `SNO` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SSEX` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SNO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('001', 'KangKang', 'M');
INSERT INTO `student` VALUES ('002', 'Mike', 'M');
INSERT INTO `student` VALUES ('003', 'Jane', 'F');
INSERT INTO `student` VALUES ('005', '张三', 'M');
INSERT INTO `student` VALUES ('006', '蒋建飞', 'M');
INSERT INTO `student` VALUES ('009', '蒋建飞', '男');
INSERT INTO `student` VALUES ('010', '蒋建飞1', '男');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `time` int(11) NULL DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'jiangjf', '查询所有学生', 118, 'com.jiangjf.studyweb.controller.StudentController.queryStudentList()', '', '127.0.0.1', '2020-03-22 17:42:55');
INSERT INTO `sys_log` VALUES (2, 'jiangjf', '查询所有学生', 3, 'com.jiangjf.studyweb.controller.StudentController.queryStudentList()', '', '127.0.0.1', '2020-03-22 17:43:09');
INSERT INTO `sys_log` VALUES (3, 'jiangjf', '添加学生', 18, 'com.jiangjf.studyweb.controller.StudentController.add()', '  student: Student(sno=009, name=蒋建飞, sex=男)', '127.0.0.1', '2020-03-22 17:44:15');
INSERT INTO `sys_log` VALUES (4, 'jiangjf', '添加学生', 11, 'com.jiangjf.studyweb.controller.StudentController.add()', '  student: Student(sno=009, name=蒋建飞, sex=男)', '127.0.0.1', '2020-03-22 17:44:43');
INSERT INTO `sys_log` VALUES (5, 'jiangjf', '添加学生', 131, 'com.jiangjf.studyweb.controller.StudentController.add()', '  student: Student(sno=009, name=蒋建飞, sex=男)', '127.0.0.1', '2020-03-22 17:46:08');
INSERT INTO `sys_log` VALUES (6, 'jiangjf', '查询所有学生', 53, 'com.jiangjf.studyweb.controller.StudentController.queryStudentList()', '', '127.0.0.1', '2020-03-22 17:46:17');
INSERT INTO `sys_log` VALUES (7, 'jiangjf', '查询所有学生', 109, 'com.jiangjf.studyweb.controller.StudentController.queryStudentList()', '', '127.0.0.1', '2020-03-22 19:14:36');
INSERT INTO `sys_log` VALUES (8, 'jiangjf', '查询所有学生', 2, 'com.jiangjf.studyweb.controller.StudentController.queryStudentList()', '', '127.0.0.1', '2020-03-22 19:14:40');
INSERT INTO `sys_log` VALUES (9, 'jiangjf', '添加学生', 4, 'com.jiangjf.studyweb.controller.StudentController.add()', '  student: Student(sno=010, name=蒋建飞1, sex=男)', '127.0.0.1', '2020-03-22 19:15:37');
INSERT INTO `sys_log` VALUES (10, 'jiangjf', '查询所有学生', 5, 'com.jiangjf.studyweb.controller.StudentController.queryStudentList()', '', '127.0.0.1', '2020-03-22 19:15:41');

SET FOREIGN_KEY_CHECKS = 1;
