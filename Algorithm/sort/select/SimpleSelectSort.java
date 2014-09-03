package Algorithm.sort.select;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/4.
 *
 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
 * 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 *
 * 时间复杂度：与初始排列无关， n(n-1)/2
 *
 * 空间复杂度：最好（有序）：0； 最差： 3（n-1）
 *
 * 不稳定，适合元素规模很大，但是排序码较小的序列。（因为移动成本比比较成本高）
 */
public class SimpleSelectSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
           int k = i;
           for (int j = i; j < length; j++) {
               if (array[j] < array[k]) {
                   k = j;
               }
           }
           if (k != i) {
               SortUtil.swap(array, k , i);
           }
        }
    }
}
