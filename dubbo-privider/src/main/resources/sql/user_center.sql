/*
Navicat MySQL Data Transfer

Source Server         : baiyu
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : user_center

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-06-12 00:41:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父地址ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '地址名称',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序  0 表示无序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0没有删除  1 已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='省市区地址表';

-- ----------------------------
-- Table structure for receive_address
-- ----------------------------
DROP TABLE IF EXISTS `receive_address`;
CREATE TABLE `receive_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) NOT NULL COMMENT '用户ID 关联登录表',
  `receiver_name` varchar(50) NOT NULL DEFAULT '' COMMENT '收货人名称',
  `receiver_phone` varchar(20) NOT NULL DEFAULT '' COMMENT '收货人手机号码',
  `province` int(11) NOT NULL DEFAULT '0' COMMENT '省-关联地址ID',
  `city` int(11) NOT NULL DEFAULT '0' COMMENT '市-关联地址ID',
  `county` int(11) NOT NULL DEFAULT '0' COMMENT '县-关联城市ID',
  `village` int(11) NOT NULL DEFAULT '0' COMMENT '乡',
  `address_detail` varchar(255) NOT NULL DEFAULT '' COMMENT '详细地址',
  `is_default` int(2) NOT NULL DEFAULT '0' COMMENT '是不是默认  1是 0不是  默认不是',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0没有删除  1 已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收货地址';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) NOT NULL COMMENT '用户ID 关联用户登录表',
  `nick_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `head_img` bigint(20) NOT NULL DEFAULT '0' COMMENT '头像ID',
  `head_img_url` varchar(100) NOT NULL DEFAULT '' COMMENT '头像路径',
  `real_name` varchar(50) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `qq` varchar(50) NOT NULL DEFAULT '' COMMENT 'QQ',
  `wechat` varchar(50) NOT NULL DEFAULT '' COMMENT '微信号',
  `province` int(11) NOT NULL DEFAULT '0' COMMENT '省-关联地址ID',
  `city` int(11) NOT NULL DEFAULT '0' COMMENT '市-关联地址ID',
  `county` int(11) NOT NULL DEFAULT '0' COMMENT '县-关联城市ID',
  `village` int(11) NOT NULL DEFAULT '0' COMMENT '乡',
  `address_detail` varchar(255) NOT NULL DEFAULT '' COMMENT '详细地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0没有删除  1 已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户基础信息表';

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '登录用户名',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `password` varchar(50) NOT NULL COMMENT '登录密码',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '用户状态 0未完善 1有效  2黑名单  3注销（用户操作）  4下架（平台操作）',
  `last_login_time` datetime NOT NULL COMMENT '最后一次登录时间',
  `create_time` datetime NOT NULL COMMENT '创建时间-注册时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0没有删除  1 已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录信息表';

-- ----------------------------
-- Table structure for user_login_record
-- ----------------------------
DROP TABLE IF EXISTS `user_login_record`;
CREATE TABLE `user_login_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) NOT NULL COMMENT '用户ID 关联登录表',
  `ip_address` varchar(255) NOT NULL COMMENT '登录IP地址',
  `source_type` int(11) NOT NULL DEFAULT '1' COMMENT '登录来源 1 iPhone 2 android 3 PC',
  `create_time` datetime NOT NULL COMMENT '创建时间-登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录记录表';
