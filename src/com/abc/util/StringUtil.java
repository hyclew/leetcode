package com.abc.util;

public class StringUtil {

    public static int charInString(char c, String s) {

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (c == ch) {
                return i;
            }
        }
        return -1;
    }
}
