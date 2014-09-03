package Algorithm.sort.insert;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/3.
 *
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 *
 * 时空复杂度比较难计算。时间复杂度：O（nlog2n）～O（n2），平均nlog2n
 *
 * 不稳定，Shell排序比冒泡排序快5倍，比插入排序大致快2倍。Shell排序比起QuickSort，MergeSort，HeapSort慢很多。
 * 但是它相对比较简单，它适合于数据量在5000以下并且速度并不是特别重要的场合。它对于数据量较小的数列重复排序是非常好的。
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        int gap = length;
        int tem;
        int j;

        do {
            gap = gap/3 + 1;
            for (int i = gap; i < length; i++) {
                if (array[i] < array[i - gap]) {
                    tem = array[i];
                    j = i - gap;
                    do {
                        array[j + gap] = array[j];
                        j = j - gap;
                    }while (j >= 0 && tem < array[j]);

                    array[j + gap] = tem;
                }
            }
        }while (gap > 1);


    }
}
