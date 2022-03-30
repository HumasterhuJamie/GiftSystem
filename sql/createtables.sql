-- ----------------------------
-- Table structure for cus_select_data
-- ----------------------------
CREATE TABLE `cus_select_data` (
	`id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`product_id` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`product_name` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`product_stock` INT(10) NULL DEFAULT NULL,
	`total` INT(10) NULL DEFAULT NULL,
	`product_type` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`img_url` VARCHAR(500) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`supplier` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`cus_id` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`cus_address` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`cus_phone` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`price` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`cus_email` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`cus_deliver_date` TIMESTAMP NULL DEFAULT NULL,
	`product_status` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`receive_time` TIMESTAMP NULL DEFAULT NULL,
	`recipient` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`cus_mobile` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`cus_city` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	`update_time` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=DYNAMIC
;
-- ----------------------------
-- Table structure for product_info
-- ----------------------------
CREATE TABLE `product_info` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`product_id` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`product_name` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`product_stock` INT(10) NULL DEFAULT NULL,
	`total` INT(10) NULL DEFAULT NULL,
	`product_type` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`price` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`img_url` VARCHAR(10000) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`supplier` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `product_id` (`product_id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=DYNAMIC
;
-- ----------------------------
-- Table structure for cus_select_log
-- ----------------------------
CREATE TABLE `cus_select_log` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`product_id` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`cus_id` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`cus_option` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
	`exe_date` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=DYNAMIC
;
-- ----------------------------
-- Records of product_date_info
-- ----------------------------
CREATE TABLE `product_date_info` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`product_id` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`product_date_stock` INT(10) NULL DEFAULT NULL,
	`product_date_total` INT(10) NULL DEFAULT NULL,
	`product_date` TIMESTAMP NULL DEFAULT NULL,
	`product_display_date` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `product_id` (`product_id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=DYNAMIC
;

