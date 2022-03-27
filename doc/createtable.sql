-- ----------------------------
-- Table structure for cus_select_data
-- ----------------------------
DROP TABLE IF EXISTS `cus_select_data`;
CREATE TABLE `cus_select_data`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `product_stock` int(10) NOT NULL ,
  `total` int(10) NOT NULL DEFAULT 2000,
  `product_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `img_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `supplier` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `cus_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `cus_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `cus_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `cus_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `cus_deliver_date` timestamp(0) NULL DEFAULT NULL ,
  `product_status` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `receive_time` timestamp(0) NULL DEFAULT NULL ,
  `recipient` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `cus_mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `cus_city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) USING BTREE
) CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `product_stock` int(10) NOT NULL ,
  `total` int(10) NOT NULL DEFAULT 2000,
  `product_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `img_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `supplier` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,  
  PRIMARY KEY (`id`) USING BTREE
) CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cus_select_log
-- ----------------------------
DROP TABLE IF EXISTS `cus_select_log`;
CREATE TABLE `cus_select_log`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `cus_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `cus_option` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
  `exe_date` timestamp(0) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) USING BTREE
) CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_date_info
-- ----------------------------
DROP TABLE IF EXISTS `product_date_info`;
CREATE TABLE `product_date_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,  
  `product_date_stock` int(10) NOT NULL ,
  `product_date_total` int(10) NOT NULL ,
  `product_date` timestamp(0) NULL DEFAULT NULL ,
  `product_display_date` timestamp(0) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) USING BTREE
) CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
