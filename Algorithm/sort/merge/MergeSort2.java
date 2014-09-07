package Algorithm.sort.merge;

import Algorithm.sort.Sort;

/**
 * Created by soft on 2014/9/6.
 */
public class MergeSort2 implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        int len = 1;

        while (len < length) {
            int s = len;
            int i = 0;
            len = 2*s;

            while (i + len < length) {
                merge(array, i, i+s-1, i+len-1);
                i = i + len;
            }

            if (i+s < length) {
                merge(array, i, i+s-1, length-1);
            }
        }
    }


    private void merge(int[] array, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        int length = high - low + 1;
        int[] temArray = new int[length];
        int k = 0;
        while (i <= middle && j <= high) {
            if (array[i] < array[j]) {
                temArray[k++] = array[i++];
            } else {
                temArray[k++] = array[j++];
            }
        }

        while (i <= middle) {
            temArray[k++] = array[i++];
        }
        while (j <= high) {
            temArray[k++] = array[j++];
        }

        for (int m = 0; m < length; m++) {
            array[low++] = temArray[m];
        }
    }
}
