package com.ruoyi.common.utils;



import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @program: ruoyi
 * @description:
 * @author: 云晓得峰
 * @create: 2020-08-10 23:26
 **/
public class ListMapToBeanUtils {



    /**
     * List<Map<String, Object>>转List<T>
     */
    public static <T> List<T> castMapToBean(List<Map<String, Object>> list, Class<T> clazz) throws Exception {
        if (list == null || list.size()==0) {
            return null;
        }
        List<T> tList = new ArrayList<T>();
        // 获取类中声明的所有字段
        Field[] fields = clazz.getDeclaredFields();

        T t;
        for (Map<String, Object> map : list) {
            // 每次都先初始化一遍,然后再设置值
            t = clazz.newInstance();
            for (Field field : fields) {
                // 把序列化的字段去除掉
                if (!"serialVersionUID".equals(field.getName())) {
                    // 由于Field都是私有属性，所有需要允许修改
                    field.setAccessible(true);

                    // 设置值, 类型要和vo中的属性名称对应好,不然会报类型转换错误
                    field.set(t, map.get(field.getName()));
                }
            }
            tList.add(t); // 把转换好的数据添加到集合中
        }
        return tList;
    }

}
