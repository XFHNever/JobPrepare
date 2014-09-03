package Algorithm.sort.insert;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/3.
 *
 * 将一个元素插入到已排序好的有序表中，从而得到一个新的、记录数增1的有序表。
 *
 * 时间复杂度：最优（正序）：n-1；最差（倒序）：n（n-1）/2
 *
 * 空间复杂度：最优（正序）：0；最差（倒序）：  （n+4)（n-1）/2
 *
 * 稳定的，适合基本有序的小型数组
 */
public class DirectInsertSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int tem = array[i];

            for (int j = i; j > 0; j--) {
                if (tem < array[j-1]) {
                    array[j] = array[j-1];
                } else {
                    array[j] = tem;
                    break;
                }
            }
        }
    }

    public void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                int j = i-1;
                int tem = array[i];
                while (j>0 && tem < array[j]) {
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = tem;
            }
        }
    }
}
