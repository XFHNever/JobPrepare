package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/8/31.
 *
 * 核心思想：相邻两个数据进行比较，不满足排序要求就交换位置。
 *
 * 时间复杂度：n^2, 和数组大小及初始排列顺序无关
 *
 * 空间复杂度：和排列顺序有关；正序为0，逆序为n^2
 *
 * 稳定性排序，适合长度较小数组比较。
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                }
            }
        }
    }
}
