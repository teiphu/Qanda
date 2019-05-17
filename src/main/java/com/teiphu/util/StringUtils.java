package com.teiphu.util;

/**
 * @Author Teiphu
 * @Creation 2019.05.18 上午 12:03
 **/
public class StringUtils {

    public static Integer[] stringToIntegerArray(String str) {
        if (str != null) {
            str = str.substring(1, str.length() - 1);
            String[] strArr = str.split(",");
            Integer[] topicIds = new Integer[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                int start = strArr[i].indexOf("\"");
                int end = strArr[i].lastIndexOf("\"");
                String topicStr = strArr[i].substring(start + 1, end);
                topicIds[i] = Integer.valueOf(topicStr);
            }
            return topicIds;
        } else {
            return null;
        }
    }
}
