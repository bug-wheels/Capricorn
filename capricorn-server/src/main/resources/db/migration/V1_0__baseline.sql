create table datacenter (
  id int unsigned auto_increment primary key,
  name varchar(60) not null unique comment '名称',
  description varchar(100) null comment '描述',
  active_status tinyint  default 0 not null comment '状态：1:禁用；0: 启用；',
  create_time datetime default current_timestamp comment '创建时间',
  update_time datetime default current_timestamp on update current_timestamp comment '更新时间'
) engine = innodb character set utf8mb4 comment ='datacenter 配置';

create table namespace (
  id int unsigned auto_increment primary key,
  dc_id int unsigned comment '数据中心 id',
  name varchar(60) not null unique comment '名称',
  description varchar(100) null comment '描述',
  create_time datetime default current_timestamp comment '创建时间',
  update_time datetime default current_timestamp on update current_timestamp comment '更新时间'
) engine = innodb character set utf8mb4 comment ='namespace 配置';

create table service_instance (
  id int unsigned auto_increment primary key,
  dc_id int unsigned comment '数据中心 id',
  ns_id int unsigned comment 'namespace id',
  instance_id varchar(64) unique,
  service_id varchar(64),
  host varchar(15) not null,
  port int unsigned not null,
  metadata varchar(100) null comment '描述',
  last_heartbeat_time datetime default current_timestamp comment '最后心跳时间',
  create_time datetime default current_timestamp comment '创建时间',
  update_time datetime default current_timestamp on update current_timestamp comment '更新时间'
) engine = innodb character set utf8mb4 comment ='instance 配置';