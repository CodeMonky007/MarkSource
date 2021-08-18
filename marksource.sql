/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : marksource

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 24/12/2020 22:37:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file_source
-- ----------------------------
DROP TABLE IF EXISTS `file_source`;
CREATE TABLE `file_source`  (
  `file_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fileType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件类型',
  `fileDes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件描述',
  `fileSize` double(255, 0) NULL DEFAULT NULL COMMENT '文件大小',
  `fileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source`  (
  `source_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `source_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源类型',
  `source_des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `source_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源链接',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源创建时间',
  `source_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源位置',
  PRIMARY KEY (`source_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of source
-- ----------------------------
INSERT INTO `source` VALUES ('b55ccd5d2a46751c33fdb44e3cfa33a1', '后端数据操作', 'Servlet连接数据库进行数据的增删改查', 'https://blog.csdn.net/sun_ting_chuan/article/details/84337659', '2020-12-07 13:06:31', '网络资源');
INSERT INTO `source` VALUES ('e644d299b6bcc8da0ea8e4bd66964f9b', '文章', '主题是信息化的发展', 'test', '2020-12-07 18:04:00', '本地资源');
INSERT INTO `source` VALUES ('d419c18f78603e7ff534e528520b4133', 'Layui前端框架', 'Layui文件下载', 'blog.csdn.net/libusi001/article/details/100689081', '2020-12-12 23:30:55', '网络资源');
INSERT INTO `source` VALUES ('da7c12f92a49c81abf4f43d7a794a09d', 'Layui前端框架', 'Layui常用详细功能案例', 'https://blog.csdn.net/libusi001/article/details/100065911', '2020-12-12 22:27:24', '网络资源');
INSERT INTO `source` VALUES ('78d753b3fb162e8f2a36329924142c0d', '百度文库', '知识点解析', 'https://blog.csdn.net/weixin_41606652/article/details/84262729', '2020-12-07 18:02:49', '本地资源');
INSERT INTO `source` VALUES ('cf0a37dde7942dd78e5974cc7c2d1a85', 'test3', 'test3', 'E:/avav/afg/agt/sh', '2020-12-07 18:09:07', '本地资源');
INSERT INTO `source` VALUES ('6721435487328b1e227f8afd1e63806d', '论文', '关于环境保护的文章', 'E:/se/af/agt/ag/ag', '2020-12-07 18:05:06', '本地资源');
INSERT INTO `source` VALUES ('4443b9fe88a8257523a1e36a8a60c2c7', '优秀背景图片', '关于风景的图片', 'E:/svb/s/ssss', '2020-12-07 18:05:55', '本地资源');
INSERT INTO `source` VALUES ('551a57a9a6585ed9f08e5c49a536f495', 'test4', '测试4', 'E:/fjnsv/ykgdfb bs/agh', '2020-12-07 18:09:31', '本地资源');
INSERT INTO `source` VALUES ('edf86b0d38f53cf271cc1c95dc88e3f2', '前端插件Layui', '前端框架工具', 'https://www.layui.com/demo/form.html', '2020-12-11 21:10:49', '网络资源');
INSERT INTO `source` VALUES ('55616a4636f06a460096bc7f03136fa3', '前端点击事件问题', '解决onclick和a标签同时使用的闪退问题', 'https://www.cnblogs.com/Mygirl/archive/2013/04/10/3012867.html', '2020-12-11 23:44:34', '网络资源');
INSERT INTO `source` VALUES ('283193a995909a566ca0890020199f68', 'Layui中的文件上传', 'Layui文件单个上传、批量上传、多条件上传', 'https://blog.csdn.net/libusi001/article/details/102841560', '2020-12-13 16:35:06', '网络资源');
INSERT INTO `source` VALUES ('de0310bcf4f4a3157b1f050d785640e0', 'layui前端框架', 'layui前端分页', 'https://my.oschina.net/u/4283501/blog/3449362', '2020-12-13 15:41:37', '网络资源');
INSERT INTO `source` VALUES ('0add92039552a1e3d5571979bcaf206e', '阿女', 'sgsg', '阿福', '2020-12-14 17:06:40', '本地资源');
INSERT INTO `source` VALUES ('aa81d145350f5e186aed8eb32f4bcffb', 'ss', 'sss', 'ssss', '2020-12-14 17:09:51', '本地资源');
INSERT INTO `source` VALUES ('0e774ef20018ce2009994d7eaa2d9d34', 'agasg', 'afagag', 'afagv', '2020-12-14 17:10:00', '本地资源');
INSERT INTO `source` VALUES ('24089508cc4cde4a407c5875b62e691b', 'afvafD', 'afaf', 'af', '2020-12-14 17:10:47', '本地资源');
INSERT INTO `source` VALUES ('157440df8c593e23e5740499e95bd057', 'dhdh', 'afag', 'sdhdh', '2020-12-14 17:10:54', '本地资源');
INSERT INTO `source` VALUES ('ebb06736b8142a7fae9e389ef2796a43', 'FAGsh', 'sgsgsh', 'agfag', '2020-12-14 17:11:03', '本地资源');
INSERT INTO `source` VALUES ('fa1d6efd5a64e70d96e861a8d2679f3a', '数学公式', '关于体积的公式', 'https://baike.baidu.com/item/%E4%BD%93%E7%A7%AF%E5%85%AC%E5%BC%8F/8880018?fr=aladdin', '2020-12-20 18:58:19', '网络资源');
INSERT INTO `source` VALUES ('3771586ee2d66840f3558e0930688ac4', 'jsp+servlet', '用户修改密码的功能', 'https://blog.csdn.net/yongh701/article/details/44004575', '2020-12-20 22:48:00', '网络资源');
INSERT INTO `source` VALUES ('00b5a611f8ca550ca4e1f99bd3b70923', '前端过来的中文用户名进行编码', '用户名中文登录不了', 'https://blog.csdn.net/qq_41781953/article/details/106219454', '2020-12-21 15:33:51', '网络资源');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2eb8aa17d06d0f1d71ac6f3520ce5d79', '嘤嘤嘤', 'zdb.123');
INSERT INTO `user` VALUES ('4c669b5a787384eb14fccc14258632be', 'test1', 'test1.123');
INSERT INTO `user` VALUES ('5ba49271e4c0c159a701e2478c6c7691', 'yyyy', 'yyy.123');
INSERT INTO `user` VALUES ('177678e19840b5fc2b670b339b6d0868', '那年冬天', 'snow.123');
INSERT INTO `user` VALUES ('8c2bc7dcc245f8a8b59b1434fa69751c', 'test2', 'test2.123');
INSERT INTO `user` VALUES ('e5e5ef959f8da7d692aff3b446c58861', 'javaWeb', 'zdb.123');

SET FOREIGN_KEY_CHECKS = 1;
