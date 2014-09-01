package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/8/31.
 *
 * 对Bubble sort的改进--使用标志位exchangge标记是否发生逆序和交换，当exchange=false，表明已经排好序，可以终止冒泡。
 *
 * 如果是排好序的，只需要一趟冒泡，最好的情况下需要n-1次比较和0次交换；
 * 最差情况下，大约需要n(n-1)/2次比较和3n(n-1)/2交换次数。
 *
 */
public class BubbleImprove implements Sort{
    @Override
    public void sort(int[] array) {
        boolean exchange = false;
        int length = array.length;

        for (int i = 0; i < length; i++) {
            exchange = false;
            for (int j = i; j < length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                    exchange = true;
                }
            }

            if (!exchange) {
                 return;
            }
        }
    }
}
