/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : news

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 08/07/2021 15:23:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '新闻id',
  `news_title` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL COMMENT '新闻标题',
  `news_content` text COLLATE utf8mb4_croatian_ci COMMENT '新闻内容',
  `news_desc` varchar(255) COLLATE utf8mb4_croatian_ci DEFAULT NULL COMMENT '新闻简介',
  `news_type` int DEFAULT NULL COMMENT '新闻类型',
  `news_thumb` varchar(40) COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '新闻缩略图url',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci COMMENT='新闻主要内容';

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for news_type
-- ----------------------------
DROP TABLE IF EXISTS `news_type`;
CREATE TABLE `news_type` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '新闻类型id',
  `news_type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL COMMENT '新闻类型',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci COMMENT='新闻类别';

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for join
-- ----------------------------
DROP TABLE IF EXISTS `join`;
CREATE TABLE `join`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '加盟者id',
  `franchisees_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '加盟者姓名',
  `franchisees_phonenum` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '加盟者电话',
  `franchisees_address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '加盟者目标开店地址',
  `franchisees_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '加盟原因',
  `apply_time` datetime(0) NOT NULL COMMENT '申请加盟时间',
  `is_deleted` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0：未删除   1：已删除',
  `create_time` datetime(0) NOT NULL COMMENT '表的创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '表的修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '申请加盟表' ROW_FORMAT = Compressed;

-- ----------------------------
-- Records of join
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `good_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '商品名称',
  `good_desc` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '商品简介',
  `good_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '商品状态：0表示非新品，1表示新品',
  `good_category_id` bigint(0) UNSIGNED NOT NULL COMMENT '商品分类的id',
  `good_thumb` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '商品缩略图的url',
  `is_deleted` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除：0表示未删除，1表示删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for good_category
-- ----------------------------
DROP TABLE IF EXISTS `good_category`;
CREATE TABLE `good_category`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品分类ID',
  `good_category_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '商品分类名称',
  `good_category_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '分类状态：0表示正常，1表示有新品，2表示屏蔽',
  `is_deleted` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除：0表示未删除，1表示删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;


SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for introduction
-- ----------------------------
DROP TABLE IF EXISTS `introduction`;
CREATE TABLE `introduction`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `introduce_module_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店咨询介绍板块的名称',
  `introduce_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店咨询介绍内容',
  `is_conceal` tinyint NOT NULL DEFAULT 0 COMMENT '0：正常显示 1：隐藏内容',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '0：表未删除 1：表已删除',
  `create_time` datetime NOT NULL COMMENT '表创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '最后一次修改表的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '门店简介浏览表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of introduction
-- ----------------------------


-- ----------------------------
-- Table structure for store_info
-- ----------------------------
DROP TABLE IF EXISTS `store_info`;
CREATE TABLE `store_info`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `store_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店的名字',
  `store_opentime` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店的营业时间 如8：00 -- 18：00',
  `store_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店的地址',
  `store_tele` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '门店外送电话',
  `is_conceal` tinyint NOT NULL DEFAULT 0 COMMENT '0: 正常显示\r\n1：隐藏状态',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0：未删除 1：已删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '门店列表信息的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store_info
-- ----------------------------

-- ----------------------------
-- Table structure for store_introduction
-- ----------------------------
DROP TABLE IF EXISTS `store_introduction`;
CREATE TABLE `store_introduction`  (
  `id` int UNSIGNED NOT NULL,
  `store_id_fk` int NOT NULL COMMENT '店铺ID号',
  `introduction_id_fk` int NOT NULL COMMENT '简介ID号',
  PRIMARY KEY (`store_id_fk`, `introduction_id_fk`) USING BTREE,
  INDEX `fk_intro_id`(`introduction_id_fk`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store_introduction
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company_customer
-- ----------------------------
DROP TABLE IF EXISTS `company_customer`;
CREATE TABLE `company_customer`  (
  `id` bigint(0) NOT NULL COMMENT '自增id',
  `company_id` int(0) NOT NULL COMMENT '公司id',
  `customer_id` int(0) NOT NULL COMMENT '顾客id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company_data
-- ----------------------------
DROP TABLE IF EXISTS `company_data`;
CREATE TABLE `company_data`  (
  `id` bigint(0) NOT NULL COMMENT '自增id',
  `company_introduce` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '介绍',
  `brand_introduce` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '品牌释义',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0：未删除 1：已删除',
  `creat_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL  COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company_information
-- ----------------------------
DROP TABLE IF EXISTS `company_information`;
CREATE TABLE `company_information`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `company_name` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司名称',
  `company_phone` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '招商热线',
  `company_fax` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司传真',
  `company_email` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司邮箱',
  `company_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司地址',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0：未删除 1：已删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `company_name`(`company_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_information
-- ----------------------------
DROP TABLE IF EXISTS `customer_information`;
CREATE TABLE `customer_information`  (
  `id` bigint(0) NOT NULL COMMENT '自增id',
  `customer_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客名字',
  `customer_phone` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客电话',
  `customer_email` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客邮箱',
  `customer_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客留言',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0：未删除 1：已删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manager_information
-- ----------------------------
DROP TABLE IF EXISTS `manager_information`;
CREATE TABLE `manager_information`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `manager_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人事管理员姓名',
  `manager_phone` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机热线',
  `company_id` int(0) NOT NULL COMMENT '公司id',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0：未删除 1：已删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NULL DEFAULT NULL ,
  `is_deleted` tinyint(1) DEFAULT '0',
  `url` varchar(64) DEFAULT NULL COMMENT '对应实体的URL',
  `associate_id` bigint NOT NULL COMMENT '该对象与其他实体关联的ID',
  `status` int DEFAULT '0' COMMENT '图片的状态，0为正常，1为屏蔽（不启用），2为首页展示',
  `order_num` int DEFAULT '0' COMMENT '前端展示的顺序，大号在前',
  `type` varchar(8) NOT NULL COMMENT '标识图片将会应用哪一个页面，例如防止于首页的图片此处值为''HOME''.',
  `link` varchar(64) NULL COMMENT '图片跳转链接'
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='存储项目中需要用到的所有图片，仅保存对象URL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-08 20:39:31