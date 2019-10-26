package com.abc.quiz;

public class Q0003 {

    public static void main(String[] args) {
        Q0003 q = new Q0003();
        String s = "aba";
        System.out.println(q.lengthOfLongestSubstring1(s));

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 1;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        int start = 0, max = 0, pos = 0, cur = 0;
        char c;
//        char c_sub;
        String s_sub;
        for (cur = 0; cur < s.length(); cur++) {
//            pos = StringUtil.charInString(s.charAt(i), s.substring(start, end + 1));
            c = s.charAt(cur);
            s_sub = s.substring(start, cur);

            pos = s_sub.indexOf(c);
//            pos = -1;
//            for (int j = 0; j < s_sub.length(); j++) {
//                c_sub = s_sub.charAt(j);
//                if (c == c_sub) {
//                    pos = j;
//                    break;
//                }
//            }

            if (pos >= 0) {
                start = start + pos + 1;
            }


            max = Math.max(max, cur - start + 1);
        }
        return max;
    }
}

