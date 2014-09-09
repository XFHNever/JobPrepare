package Algorithm.sort.distribution;

import Algorithm.sort.Sort;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by never on 2014/9/8.
 *
 * 核心思想： 最低位优先
 *
 * 时间复杂度：　ｄ（ｎ＋ｒａｄｉｘ）
 *
 * 空间复杂度：　２＊ｎ
 *
 * 稳定，适合元素个数较多而排序码位数较少情况。
 */
public class LSDRadixSort implements Sort {
    @Override
    public void sort(int[] array) {

    }

    private void radixSort(LinkedList<Integer> list) {
        //todo
    }
}
