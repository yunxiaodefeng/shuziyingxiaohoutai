-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网点', '2030', '1', '/mbkj/store', 'C', '0', 'mbkj:store:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '网点菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网点查询', @parentId, '1',  '#',  'F', '0', 'mbkj:store:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网点新增', @parentId, '2',  '#',  'F', '0', 'mbkj:store:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网点修改', @parentId, '3',  '#',  'F', '0', 'mbkj:store:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网点删除', @parentId, '4',  '#',  'F', '0', 'mbkj:store:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网点导出', @parentId, '5',  '#',  'F', '0', 'mbkj:store:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
