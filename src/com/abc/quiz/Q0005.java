package com.abc.quiz;

import java.util.stream.Stream;

public class Q0005 {

    public static void main(String[] args) {
        Q0005 q = new Q0005();

        String s;

        s = "a!";
        System.out.println(q.longestPalindrome(s));

        s = "ababc";
        System.out.println(q.longestPalindrome(s));

        s = "aaa";
        System.out.println(q.longestPalindrome(s));

        s = "aaaa";
        System.out.println(q.longestPalindrome(s));

        s = "abcba";
        System.out.println(q.longestPalindrome(s));

    }

    public String longestPalindrome(String s) {
        char[] T = new char[s.length() * 2 + 3];
        T[0] = '!';
        T[1] = '#';
        int n = 2;
        for (char c : s.toCharArray()) {
            T[n++] = c;
            T[n++] = '#';
        }
        T[n++] = '$';
        int[] P = new int[T.length];
        int mx = 0, c = 0;
        for (int i = 1; i < n - 1; i++) {
            P[i] = mx > i ? Math.min(mx - i, P[2 * c - i]) : 0;
            while (T[i + P[i] + 1] == T[i - P[i] - 1]) P[i]++;
            if (mx < i + P[i]) {
                mx = i + P[i];
                c = i;
            }
        }

        int maxLen = 0, maxCen = 0;
        for (int i = 0; i < n; i++) {
            if (maxLen < P[i]) {
                maxLen = P[i];
                maxCen = i;
            }
        }

        return s.substring((maxCen - maxLen - 1) / 2, (maxCen + maxLen - 1) / 2);
    }

    public String longestPalindrome8(String s) {
        if (s.length() < 2) return s;

        int sLen = s.length();
        char[] chars = s.toCharArray();

        int[] p = new int[2002];
        int curPos = 0, rightPos = 0;
        int maxCurPos = 0, maxRightPos = 0, maxLen = 0;
        int r, l;
        int i, i_mirror;

        for (i = 0; i < 2 * sLen + 1; i++) {

            i_mirror = curPos - (i - curPos);
            if (rightPos > i) {
                p[i] = Math.min(rightPos - i, p[i_mirror]);
            }

            r = i + p[i] + 1;
            l = i - p[i] - 1;

            while (l > -1 && r < 2 * sLen + 1 && (r % 2 == 0 || chars[l / 2] == chars[r / 2])) {
                r++;
                l--;
                p[i]++;
            }

            if (i + p[i] > rightPos) {
                curPos = i;
                rightPos = i + p[i];
            }

            if (p[i] > maxLen) {
                maxCurPos = i;
                maxLen = p[i];
                //maxRightPos = i + p[i];
            }

        }

        return s.substring((maxCurPos - maxLen) / 2, (maxCurPos + maxLen) / 2);
//        return s.substring(maxCurPos - maxRightPos / 2, maxRightPos / 2);
    }

    public String longestPalindrome7(String s) {
        if (s.length() < 2) return s;
        int sLen = s.length();
        int[] p = new int[2002];
        int curPos = 0, rightPos = 0, maxCurPos = 0, maxRightPos = 0, r, l;
        int i, i_mirror, j;

        for (i = 0; i < 2 * sLen + 1; i++) {

            i_mirror = curPos - (i - curPos);
            if (rightPos > i) {
                p[i] = Math.min(rightPos - i, p[i_mirror]);
            }

            for (j = p[i] + 1; j < p.length; j++) {
                r = i + j;
                l = i - j;
                if (l < 0 || r > 2 * sLen) break;
                if (r % 2 == 0 || s.charAt(l / 2) == s.charAt(r / 2)) {
//                    r++;
//                    l--;
                    p[i]++;
                } else {
                    break;
                }

            }

            if (i + p[i] > rightPos) {
                curPos = i;
                rightPos = i + p[i];
            }

            if (p[i] > p[maxCurPos]) {
                maxCurPos = i;
                maxRightPos = i + p[i];
            }

        }

        return s.substring(maxCurPos - maxRightPos / 2, maxRightPos / 2);
    }


    public String longestPalindrome9(String s) {
        if (s.length() < 2) return s;
        int sLen = s.length();
        int[] p = new int[2002];
        int maxCurPos = 0, maxRightPos = 0, curPos = 0, rightPos = 0, l = 0, r = 0;
        int i, i_mirror;

        for (i = 1; i < 2 * sLen + 1; i++) {

            i_mirror = curPos - (i - curPos);

            if (rightPos > i) {
                p[i] = Math.min(rightPos - i, p[i_mirror]);
            } else if (i % 2 == 1) {
                p[i] = 1;
            }

            l = i - p[i] - (i + p[i]) % 2 - 1;
            r = i + p[i] + (i + p[i]) % 2 + 1;

            while (l > -1 && r < 2 * sLen + 1) {

                if (s.charAt(l / 2) == s.charAt(r / 2)) {
                    r += 2;
                    l -= 2;
                    p[i] += 2;
                } else {
                    break;
                }

            }

            if (i + p[i] > rightPos) {
                curPos = i;
                rightPos = i + p[i];
            }

            if (p[i] > p[maxCurPos]) {
                maxCurPos = i;
                maxRightPos = i + p[i];
            }

        }

        return s.substring(maxCurPos - (maxRightPos + 1) / 2, maxRightPos / 2);
    }

    public String longestPalindrome6(String s) {

        Pair<Integer, Integer> solI = new Pair<>(0, -1);

        if (s.length() > 0) {
            solI = Stream.iterate(0, i -> i + 1).limit(s.length())
                    .map(i -> palinStartingFrom(i, i, s))
                    .reduce(new Pair<>(0, 0), this::getBigger);
        }
        if (s.length() > 1) {
            solI = Stream.iterate(0, i -> i + 1).limit(s.length() - 1)
                    .map(i -> palinStartingFromAndValid(i, i + 1, s))
                    .reduce(solI, this::getBigger);
        }
        return s.substring(solI.getFirst(), solI.getSecond() + 1);
    }

    private Pair<Integer, Integer> palinStartingFromAndValid(int i, int j, String s) {
        assert j == i + 1;
        if (s.charAt(i) == s.charAt(j)) {
            return palinStartingFrom(i, j, s);
        } else {
            return new Pair<>(0, 0);
        }
    }

    private Pair<Integer, Integer> palinStartingFrom(int i, int j, String s) {
        int l = i;
        int r = j;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        return new Pair<>(l, r);
    }

    private Pair<Integer, Integer> getBigger(Pair<Integer, Integer> x, Pair<Integer, Integer> y) {
        if (x.getSecond() - x.getFirst() > y.getSecond() - y.getFirst()) {
            return x;
        } else {
            return y;
        }
    }

    public String longestPalindrome4(String s) {
        if (s.length() < 2) return s;

        int len = s.length(), k, l, count, cur, curLen, maxLen = 1;
        int start = 0, end = 0;

        int[] index = new int[2000];
        for (k = 0; k < 2 * len - 1; k++) {
            index[k] = k;
        }
        index[2 * len - 1] = -1;

        for (k = 1; k <= len / 2; k++) {
            count = 0;
            for (l = 0; l < 2 * len - 1; l++) {
                if (index[l] == -1) break;

                cur = index[l];
                if (((cur + 1) / 2 - k) < 0 || (cur / 2 + k) > len - 1) continue;
                if (s.charAt((cur + 1) / 2 - k) == s.charAt(cur / 2 + k)) {
                    index[count++] = cur;

                    curLen = (cur + 1) % 2 + 2 * k;

                    if (curLen > maxLen) {
                        start = (cur + 1) / 2 - k;
                        end = cur / 2 + k;
                        maxLen = curLen;
                    }

                }
            }
            index[count] = -1;
            if (count == 0) break;

        }

        return s.substring(start, end + 1);
    }

    /**
     * 在4的基础上 将单双长度分开，直接用index[0]获取当前最大长度
     *
     * @param s
     * @return
     */
    public String longestPalindrome5(String s) {

        if (s.length() < 2) return s;

        int len = s.length(), k, l, count;
        int start = 0, end = 0;

        int[] index = new int[1001];
        int[] index1 = new int[1001];
        for (k = 0; k < 1000; k++) {
            index[k] = k;
            index1[k] = k;
        }
        index[len] = -1;
        index[len - 1] = -1;


        for (k = 1; k <= len / 2; k++) {

            count = 0;
            for (l = 0; l < len; l++) {
                if (index[l] == -1) break;

                if ((index[l] - k) < 0 || (index[l] + k) > len - 1) continue;

                if (s.charAt(index[l] - k) == s.charAt(index[l] + k)) {
                    index[count++] = index[l];
                }
            }
            index[count] = -1;

            count = 0;
            for (l = 0; l < len; l++) {
                if (index1[l] == -1) break;

                if ((index1[l] - k + 1) < 0 || (index1[l] + k) > len - 1) continue;

                if (s.charAt(index1[l] - k + 1) == s.charAt(index1[l] + k)) {
                    index1[count++] = index1[l];
                }
            }
            index1[count] = -1;

            if (index[0] != -1) {
                start = index[0] - k;
                end = index[0] + k;
            } else if (index1[0] != -1) {
                start = index1[0] - k + 1;
                end = index1[0] + k;
            } else break;

        }

        return s.substring(start, end + 1);
    }

    /**
     * 标准答案，可以通过if s_i== s_right :right++ 的方式先扩展一下得到 aaa这种单字符，然后 left right扩展，更快
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * index数字 记录当前点是否可以扩展k次
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        if (s.length() < 2) return s;

        int len = s.length(), k, l;
        int[] index = new int[2000];

        String result = s.substring(0, 1), tempResult;

        for (k = 1; k <= len / 2; k++) {
            for (l = 2 * k - 1; l < 2 * len - 2 * k; l++) {
                if (index[l] == k - 1 && s.charAt((l + 1) / 2 - k) == s.charAt(l / 2 + k)) {
                    index[l]++;
                    tempResult = s.substring((l + 1) / 2 - k, l / 2 + k + 1);

                    if (tempResult.length() > result.length()) result = tempResult;
                }
            }
        }

        return result;
    }

    /**
     * 最笨的办法，动态规划二维数组
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {

        if (s.length() < 2) return s;

        int[][] index = new int[1000][1000];

        int i = 0, j = 0, len = s.length(), k = 0;
        String result = s.substring(0, 1);

        for (k = 0; k < len - 1; k++) {
            index[k][k] = 1;

            if (s.charAt(k) == s.charAt(k + 1)) {
                index[k][k + 1] = 1;
                result = s.substring(k, k + 2);
            }
        }
        index[k][k] = 1;

        for (k = 3; k < len + 1; k++) {

            i = 0;
            j = i + k - 1;

            for (; j < len; i++, j++) {
                if (index[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
                    index[i][j] = 1;
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    private class Pair<T, V> {
        private final T first;
        private final V second;

        private Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        private T getFirst() {
            return first;
        }

        private V getSecond() {
            return second;
        }
    }


}

