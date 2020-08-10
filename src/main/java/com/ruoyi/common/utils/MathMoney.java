package com.ruoyi.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yunXiaoDeFeng
 * @Title:
 * @Package
 * @Description:
 * @date 2018/1/2310:50
 */
public class MathMoney {
    private static final int DEF_DIV_SCALE = 10;

    public static  String siSheWuRu(String price){
        BigDecimal bigDecimal = new BigDecimal(price);

        return   String.valueOf ( bigDecimal.setScale(0,    RoundingMode.HALF_UP).doubleValue());
    }


    //这个类不能实例化
    private MathMoney() {
    }

    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static String add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).toString();
    }
    public static void main(String[] args) {
        System.out.println(div("1000","50"));
    }


    /**
     * 提供精确的减法运算。
     * @param v1 减数
     * @param v2 被减数
     * @return 两个参数的差
     */
    public static String sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);

        BigDecimal b2 = new BigDecimal(v2);

        return b1.subtract(b2).toString();
    }


    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static String mul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).toString();
    }


    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后2位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static Double div(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_FLOOR).toString();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String[] average() {
        return null;

    }

    /**
     * TODO: 如果 value 为两个整数中间的数字，则返回二者中的偶数；即 3.5转换为4，4.5 转换为 4，而 5.5 转换为 6。  不过4.6可以转换为5，4.4转换为4
     * @author yunXiaoDeFeng
     * @date 2018/10/18 15:05
     * @param
     * @return java.lang.String
     */
    public static String zuiJinDeOuShu(String v){
        BigDecimal bigDecimal=new BigDecimal(v);
        return   bigDecimal.setScale (0,RoundingMode.HALF_EVEN).toString ();
    }


    public static String shangQuZheng(String price){
        return  new BigDecimal(price).setScale( 0, BigDecimal.ROUND_UP ).toString ();
    }
    public static Map shangQuZhengMap(String price){
        Map<String,Object> map=new HashMap<> ();
        map.put ("tuoJiaGe",new BigDecimal(price).setScale( 0, BigDecimal.ROUND_UP ).toString ());
        return  map;
    }

}
