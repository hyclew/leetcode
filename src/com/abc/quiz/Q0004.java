package com.abc.quiz;

public class Q0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] a = nums1;
        int[] b = nums2;
        if (nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        }

        int m = a.length;
        int n = b.length;

        int half = (m + n) / 2;

        int iMin = 0, iMax = m;
        int i,j;

        int maxLeft, minRight;

        while (true) {
            i = (iMin + iMax) / 2;
            j = half - i;

            if (i < iMax && a[i] < b[j - 1]) {
                iMin = i + 1;
            } else if (i > iMin && a[i - 1] > b[j]) {
                iMax = i;
            } else {
                if (i == m) {
                    minRight = b[j];
                } else if (j == n) {
                    minRight = a[i];
                } else {
                    minRight = Math.min(b[j], a[i]);
                }

                if ((m + n) % 2 == 1) {
                    return minRight;
                }

                if (i == 0) {
                    maxLeft = b[j - 1];
                } else if (j == 0) {
                    maxLeft = a[i - 1];
                } else {
                    maxLeft = Math.max(a[i - 1], b[j - 1]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        //return 0;
    }

/*    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = iMin + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = iMax - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }*/
}


