package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/1.
 *
 * 对Bubble sort的改进--记录下来每次冒泡最后一次交换发生的位置lastExchangeIndex，因为之后的数据都是有序的。
 *
 * 最好情况（正序）: 比较和记录移动的次数分别达到最小值n- 1和0
 *
 * 最坏情况（逆序）： 比较次数：Cmax= n(n-1)/2; 移动次数 Mmax=3n(n-1)/2 
 */
public class BubbleImprove2 implements Sort {
    @Override
    public void sort(int[] array) {
        int lastExchangeIndex;
        int length = array.length;
        int i = length - 1;
        while (i > 0) {
            lastExchangeIndex = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                    lastExchangeIndex = j;
                }
            }
            i = lastExchangeIndex;
        }
    }
}
