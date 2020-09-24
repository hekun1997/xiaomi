/*
Date: 2019-08-01 14:35:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `carid` varchar(64) NOT NULL,
  `userid` varchar(64) DEFAULT NULL COMMENT '用户表id',
  `proid` varchar(64) DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `checked` int(11) DEFAULT NULL COMMENT '是否选择,1=已勾选,0=未勾选',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`carid`),
  KEY `FK_Reference_2` (`userid`),
  KEY `FK_Reference_3` (`proid`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`proid`) REFERENCES `product` (`proid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cateid` varchar(64) NOT NULL COMMENT '类别Id',
  `parentid` varchar(64) DEFAULT NULL COMMENT '父类别id当id=0时说明是根节点,一级类别',
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `status` int(1) DEFAULT '1' COMMENT '类别状态1-正常,2-已废弃',
  `sortorder` int(4) DEFAULT NULL COMMENT '排序编号,同类展示顺序,数值相等则自然排序',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` varchar(64) NOT NULL COMMENT '订单子表id',
  `orderid` varchar(64) DEFAULT NULL COMMENT '订单id',
  `userid` varchar(64) DEFAULT NULL COMMENT '用户表id',
  `proid` varchar(64) DEFAULT NULL COMMENT '商品id',
  `proname` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `proimage` varchar(500) DEFAULT NULL COMMENT '商品图片地址',
  `currentunitprice` decimal(20,2) DEFAULT NULL COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
  `quantity` int(10) DEFAULT NULL COMMENT '商品数量',
  `totalprice` decimal(20,2) DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`orderid`),
  KEY `FK_Reference_8` (`userid`),
  KEY `FK_Reference_9` (`proid`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`proid`) REFERENCES `product` (`proid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` varchar(64) NOT NULL COMMENT '订单id',
  `userid` varchar(64) DEFAULT NULL COMMENT '用户id',
  `shoppingid` varchar(64) DEFAULT NULL,
  `payment` decimal(20,2) DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数',
  `paymenttype` int(4) DEFAULT NULL COMMENT '支付类型,1-在线支付',
  `postage` int(10) DEFAULT NULL COMMENT '运费,单位是元',
  `status` int(10) DEFAULT NULL COMMENT '订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭',
  `paymenttime` datetime DEFAULT NULL COMMENT '支付时间',
  `sendtime` datetime DEFAULT NULL COMMENT '发货时间',
  `endtime` datetime DEFAULT NULL COMMENT '交易完成时间',
  `closetime` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for payinfo
-- ----------------------------
DROP TABLE IF EXISTS `payinfo`;
CREATE TABLE `payinfo` (
  `payid` varchar(64) NOT NULL,
  `orderid` varchar(64) DEFAULT NULL COMMENT '订单id',
  `userid` varchar(64) DEFAULT NULL COMMENT '用户表id',
  `payplatform` int(10) DEFAULT NULL COMMENT '支付平台:1-支付宝,2-微信',
  `platformnumber` varchar(200) DEFAULT NULL COMMENT '支付流水号',
  `platformstatus` varchar(20) DEFAULT NULL COMMENT '支付状态',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`payid`),
  KEY `FK_Reference_6` (`orderid`),
  KEY `FK_Reference_7` (`userid`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payinfo
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `proid` varchar(64) NOT NULL COMMENT '商品id',
  `cateid` varchar(64) DEFAULT NULL COMMENT '类别Id',
  `name` varchar(100) NOT NULL COMMENT '商品名称',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '商品副标题',
  `mainimage` varchar(500) DEFAULT NULL COMMENT '产品主图,url相对地址',
  `subimages` text COMMENT '图片地址,json格式,扩展用',
  `detail` text COMMENT '商品详情',
  `price` decimal(20,2) NOT NULL COMMENT '价格,单位-元保留两位小数',
  `stock` int(11) NOT NULL COMMENT '库存数量',
  `status` int(6) DEFAULT '1' COMMENT '商品状态.1-在售 2-下架 3-删除',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`proid`),
  KEY `FK_Reference_1` (`cateid`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`cateid`) REFERENCES `category` (`cateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for shopping
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `shoppingid` varchar(64) NOT NULL,
  `userid` varchar(64) DEFAULT NULL COMMENT '用户表id',
  `orderid` varchar(64) DEFAULT NULL COMMENT '订单id',
  `receivername` varchar(20) DEFAULT NULL COMMENT '收货姓名',
  `receiverphone` varchar(20) DEFAULT NULL COMMENT '收货固定电话',
  `receivermobile` varchar(20) DEFAULT NULL COMMENT '收货移动电话',
  `receiverprovince` varchar(20) DEFAULT NULL COMMENT '省份',
  `receivercity` varchar(20) DEFAULT NULL COMMENT '城市',
  `receiverdistrict` varchar(20) DEFAULT NULL COMMENT '区/县',
  `receiveraddress` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`shoppingid`),
  KEY `FK_Reference_10` (`orderid`),
  KEY `FK_Reference_4` (`userid`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(64) NOT NULL COMMENT '用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `phone` varchar(20) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密码答案',
  `role` int(4) NOT NULL COMMENT '角色0-管理员,1-普通用户',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------