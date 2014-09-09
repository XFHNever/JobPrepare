package Algorithm.sort.distribution;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by soft on 2014/9/7.
 */
public class MSDRadixSort implements Sort {
    @Override
    public void sort(int[] array) {
        radixSort(array, 0, array.length-1, 2);
    }

    private  void radixSort(int[] array, int start, int end, int pos) {
        int i, j, p1, p2;
        int[] count = new int[10];
        int[] temArray = new int[end-start+1];

        if (pos <= 0) {
            return;
        }

        for (i=0; i<10; i++) {
            count[i] = 0;
        }

        for (j = start; j<=end; j++) {
            count[getDigit(array[j], pos)]++;
        }

        for (i=1; i<10; i++) {
            count[i] = count[i] + count[i-1];
        }

        for (j = start; j<=end; j++) {
            i = getDigit(array[j], pos);
            temArray[count[i]-1] = array[j];
            count[i]--;
        }

        for (i=start,j=0;i<=end;i++,j++) {
            array[i] = temArray[j];
        }


        for (i = 0; i<9;i++) {
            p1 = count[i];
            p2 = count[i+1]-1;
            radixSort(array, p1, p2, pos-1);
        }

    }

    public int getDigit(int num, int pos) {
        int temp = 1;
         for (int i = 0; i < pos - 1; i++)
            temp *= 10;
        return (num / temp) % 10;
    }
}
