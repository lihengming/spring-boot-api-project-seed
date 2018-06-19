package com.company.project.common.util;


import cn.hutool.core.util.StrUtil;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  字符串操作工具类，扩展自 hutool.cn
 * @author LErry.li
 * Date: 2018-06-15
 * Time: 14:42
 */
public class StringUtil extends StrUtil {

    /**
     *  格式化字符串（替换符为%s）
     */
    public static String formatIfArgs(String format, Object... args) {
        if (StrUtil.isEmpty(format)) {
            return format;
        }

        return (args == null || args.length == 0)  ? String.format(format.replaceAll("%([^n])", "%%$1")) : String.format(format, args);
    }

    /**
     *  格式化字符串(替换符自己指定)
     */
    public static String formatIfArgs(String format, String replaceOperator, Object... args) {
        if (isEmpty(format) || isEmpty(replaceOperator)) {
            return format;
        }

        format = replace(format, replaceOperator, "%s");
        return formatIfArgs(format, args);
    }

    /**
     * 替换字符串
     */
    public static String replace(String inString, String oldPattern, String newPattern) {
        if (isNotEmpty(inString) && isNotEmpty(oldPattern) && newPattern != null) {
            int index = inString.indexOf(oldPattern);
            if (index == -1) {
                return inString;
            } else {
                int capacity = inString.length();
                if (newPattern.length() > oldPattern.length()) {
                    capacity += 16;
                }

                StringBuilder sb = new StringBuilder(capacity);
                int pos = 0;

                for(int patLen = oldPattern.length(); index >= 0; index = inString.indexOf(oldPattern, pos)) {
                    sb.append(inString.substring(pos, index));
                    sb.append(newPattern);
                    pos = index + patLen;
                }

                sb.append(inString.substring(pos));
                return sb.toString();
            }
        } else {
            return inString;
        }
    }

}
