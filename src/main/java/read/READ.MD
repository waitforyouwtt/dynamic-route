https://blog.csdn.net/zhuyu19911016520/article/details/86562615

CREATE TABLE `route`.`Untitled`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自动增长、版本号',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '版本信息表' ROW_FORMAT = DYNAMIC;


CREATE TABLE `route`.`Untitled`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `route_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '路由id',
  `route_uri` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '转发目标uri',
  `route_order` int(11) NULL DEFAULT NULL COMMENT '路由执行顺序',
  `predicates` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '断言字符串集合，字符串结构：[{\r\n                \"name\":\"Path\",\r\n                \"args\":{\r\n                   \"pattern\" : \"/zy/**\"\r\n                }\r\n              }]',
  `filters` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '过滤器字符串集合，字符串结构：{\r\n              	\"name\":\"StripPrefix\",\r\n              	 \"args\":{\r\n              	 	\"_genkey_0\":\"1\"\r\n              	 }\r\n              }',
  `is_ebl` int(1) NULL DEFAULT NULL COMMENT '是否启用: 0 正常 1 禁用',
  `is_del` int(1) NULL DEFAULT NULL COMMENT '是否删除： 0 正常 1 删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '路由信息表' ROW_FORMAT = DYNAMIC;