package Algorithm.sort.insert;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/3.
 */
public class BinaryInsertSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int tem = array[i];
            int low = 0, high = i-1;
            while (low <= high) {
                int middle =  (low + high)/2;
                if (array[middle] > tem) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }

            }
            for (int j = i; j > low; j--) {
                array[j] = array[j-1];
            }

            array[low] = tem;
        }
    }
}
