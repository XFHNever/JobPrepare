package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/1.
 *
 * 对Bubble sort的改进--双向扫描。在排序过程中交替改变扫描方向.即先从下扫到上，再从上扫到下，来回地进行扫描，这样就得到双向冒泡排序算法
 *
 *最优（正序）;n-1和0；
 *
 * 最差（逆序）：进行[n/2]趟排序。
 * 如果只有最重的气泡在最上面（或者最轻的气泡在最下面），其余的有序，这时候就只需要比较1趟。但是在最坏的情况下，算法的复杂度也为O(n^2)。
 *
 */
public class BubbleImprove3 implements Sort {
    @Override
    public void sort(int[] array) {
        int low = 0,
            length = array.length,
            up = length -1,
            i, k;
        while (up > low) {
            for (i = k = low; i < up; i++) {
                if (array[i] > array[i+1]) {
                    int tem = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tem;
                    k = i;
                }
            }

            up = k;

            for (i = k = up; i > low; i--) {
                if (array[i] < array[i-1]) {
                    int tem = array[i];
                    array[i] = array[i-1];
                    array[i-1] = tem;
                    k = i-1;
                }
            }

            low = k;
        }


    }
}
