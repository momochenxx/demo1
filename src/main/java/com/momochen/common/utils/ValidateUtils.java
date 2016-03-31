
package com.momochen.common.utils;

import org.springframework.util.StringUtils;

/**
 * @ClassName ValidateUtils
 * @Description 通用输入校验类
 * @Author vic.fan
 * @CreateDate 2013-5-16
 * @Version V1.0
 */
public class ValidateUtils {

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     */
    private ValidateUtils() {
        super();
    }

    /**
     * @Title: isEmpty
     * @Description: 空字符串
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isEmpty(String val) {
        return val == null || "".equals(val.trim());
    }

    public static boolean isNotEmpty(String val) {
        return !isEmpty(val);
    }

    /**
     * @Title: isLength
     * @Description: 长度
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isLength(String val, int length) {
        return val != null && val.length() == length;
    }

    /**
     * @Title: isLength
     * @Description: 长度范围
     * @param val
     *            验证字符串
     * @param minLength
     * @param maxLength
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isLength(String val, int minLength, int maxLength) {
        return isShorterThan(val, maxLength) && isLongerThan(val, minLength);
    }

    /**
     * @Title: isShorterThan
     * @Description: 最大长度
     * @param val
     *            验证字符串
     * @param maxLength
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isShorterThan(String val, int maxLength) {
        return val == null || val.length() <= maxLength;
    }

    /**
     * @Title: isLongerThan
     * @Description: 最小长度
     * @param val
     *            验证字符串
     * @param minLength
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isLongerThan(String val, int minLength) {
        return val != null && val.length() >= minLength;
    }

    /**
     * @Title: isDoubleByte
     * @Description: 匹配双字节字符(包括汉字在内)：[^x00-xff]
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isDoubleByte(String val) {
        return val != null && val.matches("[^x00-xff]");
    }

    /**
     * @Title: isHtmlString
     * @Description: 匹配HTML标记的正则表达式：/< (.*)>.*|< (.*) />/
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isHtmlString(String val) {
        return val != null && val.matches("/< (.*)>.*|< (.*) />/");
    }

    /**
     * @Title: isEmail
     * @Description: 邮箱规则：用户名@服务器名.后缀
     * @Description:
     *               匹配Email地址的正则表达式：^([a-z0-9A-Z]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[
     *               a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isEmail(String val) {
        return val != null && val
                .matches("^([a-z0-9A-Z])+([a-z0-9A-Z]?+[\\-\\.\\_]?)+[a-z0-9A-Z]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}");
    }

    /**
     * @Title: isUrl
     * @Description: 匹配网址URL的正则表达式：^http://[a-zA-Z0-9./\\s]
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isUrl(String val) {
        return val != null && val.matches("^http://[a-zA-Z0-9./\\s]");
    }

    /**
     * @Title: isIdCard
     * @Description: 验证身份证是否有效15位或18位 ^\\d{15}(\\d{2}[0-9xX])?$ <包括对年月日的合法性进行验证>
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isIdCard(String val) {
        return val != null && val.matches("^\\d{15}(\\d{2}[0-9xX])?$");
    }

    /**
     * @Title: isTelePhone
     * @Description: 验证固定电话号码 ^(([0-9]{3,4})|([0-9]{3,4})-)?[0-9]{7,8}$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isTelephone(String val) {
        return val != null && val
                .matches("^(([0-9]{3,4})|([0-9]{3,4})-)?[0-9]{7,8}$");
    }

    /**
     * @Title: isMobilePhone
     * @Description: 验证移动电话号码 ^[1][3-8]+\\d{9}
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isMobilePhone(String val) {
        return val != null && val.matches("^[1][3-8]+\\d{9}");
    }

    /**
     * @Title: isChinese
     * @Description: 只能输入汉字，匹配中文字符的正则表达式：^[\u4e00-\u9fa5]*$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isChinese(String val) {
        return val != null && !val.matches("^[\u4e00-\u9fa5]*$");
    }

    /**
     * @Title: isPositiveInteger
     * @Description: 匹配正整数 ^[1-9]\\d*$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isPositiveInteger(String val) {
        return val != null && val.matches("^[1-9]\\d*$");
    }

    /**
     * @Title: isNegativeInteger
     * @Description: 匹配负整数 ^-[1-9]\\d*$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNegativeInteger(String val) {
        return val != null && val.matches("^-[1-9]\\d*$");
    }

    /**
     * @Title: isInteger
     * @Description: 匹配整数 ^-?[1-9]\\d*$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isInteger(String val) {
        return val != null && val.matches("^-?([1-9]\\d*|0)$");
    }

    /**
     * @Title: isInteger
     * @Description: 整数范围检查
     * @param val
     * @param min
     * @param max
     * @return
     */
    public static boolean isInteger(String val, int min, int max) {
        if (!isInteger(val)) {
            return false;
        }
        Integer value = Integer.valueOf(val);
        return value >= min && value <= max;
    }

    /**
     * @Title: isNotNegativeInteger
     * @Description: 匹配非负整数（正整数 + 0） ^[1-9]\\d*|0$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNotNegativeInteger(String val) {
        return val != null && val.matches("^[1-9]\\d*|0$");
    }

    /**
     * @Title: isNotPositiveInteger
     * @Description: 匹配非正整数（负整数 + 0） ^-[1-9]\\d*|0$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNotPositiveInteger(String val) {
        return val != null && val.matches("^-[1-9]\\d*|0$");
    }

    /**
     * @Title: isPositiveFloat
     * @Description: 匹配正浮点数 ^[1-9]\\d*\\.\\d*|0.\\d*[1-9]\\d*$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isPositiveFloat(String val) {
        return val != null && val.matches("^[1-9]\\d*\\.\\d*|0.\\d*[1-9]\\d*$");
    }

    /**
     * @Title: isNegativeFloat
     * @Description: 匹配负浮点数 ^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNegativeFloat(String val) {
        return val != null && val
                .matches("^-([1-9]\\d*\\.\\d*|0.\\d*[1-9]\\d*)$");
    }

    /**
     * @Title: isFloat
     * @Description: 匹配浮点数 ^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isFloat(String val) {
        return val != null && val
                .matches("^-?([1-9]\\d*\\.\\d+|0\\.\\d+[1-9]\\d*|0?\\.\\d+|0?\\.0+|0)$");
    }

    /**
     * @Title: isNotNegativeFloat
     * @Description: 匹配非负浮点数（正浮点数 + 0）^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNotNegativeFloat(String val) {
        return val != null && val
                .matches("^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$");
    }

    /**
     * @Title: isNotPositiveFloat
     * @Description: 匹配非正浮点数（负浮点数 +
     *               0）^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNotPositiveFloat(String val) {
        return val != null && val
                .matches("^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$");
    }

    /**
     * @Title: isNumber
     * @Description: 数值
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNumber(String val) {
        return isFloat(val) || isInteger(val);
    }

    /**
     * @Title: isPositiveNumber
     * @Description: 正数
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isPositiveNumber(String val) {
        return isPositiveFloat(val) || isPositiveInteger(val);
    }

    /**
     * @Title: isNegativeNumber
     * @Description: 负数
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNegativeNumber(String val) {
        return isNegativeFloat(val) || isNegativeInteger(val);
    }

    /**
     * @Title: isNumeric
     * @Description: 只能输入数字：“^[0-9]*$”
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNumeric(String val) {
        return val != null && val.matches("^[0-9]*$");
    }

    /**
     * @Title: isNumeric
     * @Description: 只能输入n位的数字：“^d{n}$”
     * @param val
     *            验证字符串
     * @param length
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNumeric(String val, int length) {
        return val != null && val.matches("^d{" + length + "}$");
    }

    /**
     * @Title: isNumeric
     * @Description: 只能输入m-n位的数字：“^d{m,n}$”
     * @param val
     *            验证字符串
     * @param minLength
     * @param maxLength
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isNumeric(String val, int minLength, int maxLength) {
        return val != null && val.matches("^d{" + minLength + "," + maxLength
                + "}$");
    }

    /**
     * @Title: isAlpha
     * @Description: 只能输入由26个英文字母组成的字符串：“^[A-Za-z]+$”
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isAlpha(String val) {
        return val != null && val.matches("^[A-Za-z]+$");
    }
    /**
     * @Title: isComplexStr
     * @Description: 只能输入字母开头，包含字母数字，"_",".",的字符串：“^[A-Za-z]+[A-Za-z0-9\.\-\_]*$”, 为验证登录名写的.
     * @param val  验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isComplexStr(String val) {
        return val != null && val.matches("^[A-Za-z]+[A-Za-z0-9\\.\\_]*$");
    }
    /**
     * @Title: isUpper
     * @Description: 只能输入由26个大写英文字母组成的字符串：“^[A-Z]+$”
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isUpper(String val) {
        return val != null && val.matches("^[A-Z]+$");
    }

    /**
     * @Title: isLower
     * @Description: 只能输入由26个小写英文字母组成的字符串：“^[a-z]+$”
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isLower(String val) {
        return val != null && val.matches("^[a-z]+$");
    }

    /**
     * @Title: isAlphaNumeric
     * @Description: 只能输入由数字和26个英文字母组成的字符串：“^[A-Za-z0-9]+$”
     * @param val
     *            验证字符串
     * @return 验证结果(true:匹配,false:不匹配)
     */
    public static boolean isAlphaNumeric(String val) {
        return val != null && val.matches("^[A-Za-z0-9]+$");
    }

    /**
     * mac地址校验
     * @param val
     * @return
     */
    public static boolean isMac(String val) {
        return val != null && val.matches("^([0-9a-fA-F]{2})(([\\\\-][0-9a-fA-F]{2}){5})$");
    }

    /**
     *
     * @Title: isDate
     * @Description: 校验日期格式，不能为空.匹配格式：YYYY-MM-DD
     * @param val
     * @return
     */
    public static boolean isDate(String val) {
        // 0001-9999
        String year = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})";

        // 1、3、5、7、8、10、12月
        String md31 = "((0{0,1}[13578]|1[02])-(0{0,1}[1-9]|[12][0-9]|3[01]))";

        // 4、6、9、11月
        String md30 = "((0{0,1}[469]|11)-(0{0,1}[1-9]|[12][0-9]|30))";

        // 平年 2月
        String md28 = "(0{0,1}2-(0{0,1}[1-9]|1[0-9]|2[0-8]))";

        // 平年
        String yearDay = year + "-" + "(" + md31 + "|" + md30 + "|" + md28
                + ")";

        // 闰年（1：能被4正常但不能被100正常；2：能被400整除 ）
        String leapYear = "([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[13579][26])00)";

        // 闰年2月29日
        String leapYearDay = "(" + leapYear + ")-0{0,1}2-29";

        String expression = "(" + yearDay + ")|(" + leapYearDay + ")";

        return val != null && !"".equals(val) && val.matches(expression);
    }

    /**
     * @Title: isDate
     * @Description: 校验日期格式，指定是否可以为空.
     * @param val
     * @param isAllowEmpty
     * @return
     */
    public static boolean isDate(String val, boolean isAllowEmpty) {

        if (isAllowEmpty && (val == null || "".equals(val))) {
            return true;
        }

        return isDate(val);
    }

    /**
     *
     * @Title: getBytesLength
     * @param max
     * @return boolean
     */
    public static boolean getBytesLength(String val, int max) {
        int length = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) > 255) {
                length += 2;
            } else {
                length++;
            }
        }
        return length > max;
    }

    /**
     * @Title: isMatch
     * @Description: 根据指定的正则表达式与指定字符串做匹配
     * @param fieldValue
     * @param extRegex
     * @return boolean
     */
    public static boolean isMatch(String val, String extRegex) {
        String tmpReg = extRegex;
        if (StringUtils.isEmpty(extRegex)) {
            tmpReg = "^[A-Za-z]+[A-Za-z0-9\\.\\_]*$";
        }
        return val != null && val.matches(tmpReg);
    }
}