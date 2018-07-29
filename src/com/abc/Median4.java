package com.abc;

public class Median4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0f;

        int[] a = nums1;
        int[] b = nums2;
        if (nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        }

        int m = a.length;
        int n = b.length;

        int half = (m + n + 1) / 2;

        int iMin = 0, iMax = m;
        int i = 0;
        int j = half - i;

        while (iMin < iMax) {
            i = (iMin + iMax) / 2;
            j = half - i;


            if (i == 0 || i == m || (a[i] < b[j + 1] && a[i + 1] > b[j])) {
                return ((double) (Math.max(a[i], b[j]) + Math.min(a[i + 1], b[j + 1]))) / 2;
            }

            if (a[i] > b[j + 1]) {
                iMax = i - 1;
            } else if (a[i + 1] < b[j]) {
                iMin = i;
            }
        }

        return median;
    }
}


