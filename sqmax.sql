drop database if exists sell;
create database sell;
use sell;

-- 类目
create table `product_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment '类目名字',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp  default current_timestamp comment '创建时间',
    `update_time` timestamp  default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`category_id`)
)comment '类目表';

create table `product_info` (
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '单价',
    `product_stock` int not null comment '库存',
    `product_description` varchar(64) comment '描述',
    `product_icon` varchar(512) comment '小图',
    `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`product_id`)
)comment '商品表';

create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment '买家名字',
    `buyer_phone` varchar(32) not null comment '买家电话',
    `buyer_address` varchar(128) not null comment '买家桌号',
    `buyer_openid` varchar(64) not null comment '买家微信openid',
    `order_amount` decimal(8,2) not null comment '订单总金额',
    `order_status` tinyint(3) not null default '0' comment '订单状态, 默认为新下单',
    `pay_status` tinyint(3) not null default '0' comment '支付状态, 默认未支付',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
)comment '订单表';

create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '当前价格,单位分',
    `product_quantity` int not null comment '数量',
    `product_icon` varchar(512) comment '小图',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
)comment '订单商品';

create table `seller_info` (
    `id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `openid` varchar(64) not null comment '微信openid',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '卖家信息表';


create table `comment` (
    `comment_id` int not null auto_increment,
    `name` varchar(64) not null comment '评论者姓名',
    `openid` varchar(64) not null comment '评论者姓名',
    `content` text not null comment '评论内容',
    `create_time` timestamp not null default current_timestamp comment '评论时间',
    primary key (`comment_id`)
)comment '评论信息表';




create table `contents`
(
    `id`      INT         not null auto_increment,
    `biaoti`     varchar(255) not null comment '标题',
    `meiti`     varchar(255) not null comment '发表媒体',
    `banmian`     varchar(255) not null comment '版面／时段',
    `zishu`     varchar(255) not null comment '字数／时长',
    `zuozhe`     varchar(64) not null comment '作者',
    `ticai`     varchar(64) not null comment '体裁',
    `beizhu`     varchar(64) not null comment '备注',
    `danwei`     varchar(64) not null comment '所属单位',
    `create_time`  timestamp   not null default current_timestamp comment '发表时间',
    primary key (`id`)
) comment '稿件表';





