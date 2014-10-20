package Algorithm.other;

/**
 * Created by soft on 2014/10/20.
 */
public class FindKMaxInTwoArrays {
    public static void main(String arg[]) {
        FindKMaxInTwoArrays findKMaxInTwoArrays = new FindKMaxInTwoArrays();
        int[] array1 = {1,3,5,7,9,11};
        int[] array2 = {2,4,6,8,10,12};
        System.out.println("result: " + findKMaxInTwoArrays.findK3(array1,0, array1.length, array2,0, array2.length, 5));
    }

    private int findK(int[] array1, int[] array2, int K) {
        int[] result = merge(array1, array2);

        return result[array1.length+array2.length - K];
    }

    private int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        int i=0, j=0, k=0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }
        while (i<array1.length) {
            result[k++] = array1[i++];
        }
        while (j<array2.length) {
            result[k++] = array2[j++];
        }

        return result;
    }

    private int findK2(int[] array1, int[] array2, int K) {
        int i = array1.length-1;
        int j = array2.length -1;
        while(K > 1 && i > 0 && j > 0) {
            if (array1[i] > array2[j]) {
                i--;
            } else {
                j--;
            }
            K--;
        }

        if (K > 1) {
            if (i==0) {
                return array2[j-K];
            } else {
                return array1[i-K];
            }
        }else {
            return Math.max(array1[i], array2[j]);
        }
    }

    private int findK3(int[] array1, int start1, int end1, int[] array2, int start2, int end2, int K) {
        if (start1 > end1) {
            return array2[start2 + K -1];
        }

        if (start2 > end2) {
            return array1[start1 + K -1];
        }

        int mid1 = (start1 + end1)/2;
        int mid2 = (start2 + end2)/2;

        int halfLen = mid1-start1 + 1 + mid2 - start2 + 1;

        if (array1[mid1] < array2[mid2]) {
            if (halfLen > K) {
                return findK3(array1, start1, end1, array2, start2, mid2-1, K);
            } else {
                return findK3(array1, mid1+1, end1, array2, start2, end2, K-(mid1-start1+1));
            }
        } else {
            if (halfLen > K) {
                return findK3(array1, start1, mid1-1, array2, start2, end2, K);
            } else {
                return findK3(array1, start1, end1, array2, mid2+1, end2, K-(mid2-start2+1));
            }
        }
    }
}
