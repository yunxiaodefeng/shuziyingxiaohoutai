-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('数据统计', '2013', '1', '/mbkj/usermonthtarget', 'C', '0', 'mbkj:usermonthtarget:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '数据统计菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('数据统计查询', @parentId, '1',  '#',  'F', '0', 'mbkj:usermonthtarget:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('数据统计新增', @parentId, '2',  '#',  'F', '0', 'mbkj:usermonthtarget:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('数据统计修改', @parentId, '3',  '#',  'F', '0', 'mbkj:usermonthtarget:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('数据统计删除', @parentId, '4',  '#',  'F', '0', 'mbkj:usermonthtarget:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('数据统计导出', @parentId, '5',  '#',  'F', '0', 'mbkj:usermonthtarget:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
