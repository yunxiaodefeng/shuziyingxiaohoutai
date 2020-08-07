-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('录入业绩类型信息', '2030', '1', '/mbkj/standard', 'C', '0', 'mbkj:standard:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '录入业绩类型信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('录入业绩类型信息查询', @parentId, '1',  '#',  'F', '0', 'mbkj:standard:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('录入业绩类型信息新增', @parentId, '2',  '#',  'F', '0', 'mbkj:standard:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('录入业绩类型信息修改', @parentId, '3',  '#',  'F', '0', 'mbkj:standard:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('录入业绩类型信息删除', @parentId, '4',  '#',  'F', '0', 'mbkj:standard:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('录入业绩类型信息导出', @parentId, '5',  '#',  'F', '0', 'mbkj:standard:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
