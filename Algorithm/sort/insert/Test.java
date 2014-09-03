package Algorithm.sort.insert;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/3.
 *
 * ʹ���۰�������Ѱ��Ԫ�ز���λ�á�
 *
 * ʱ�临�Ӷ�:���ʼ�����޹أ�����������Ԫ�ظ�����nlog2n
 *
 * �ռ临�Ӷȣ���ֱ�Ӳ�������һ����������Ԫ�صĳ�ʼ���С�
 *
 * �ȶ����ʺ�������С�����飬�ź�����߻�������ֱ�Ӳ�������ʡ�
 */
public class Test {
    public static void main(String arg[]) {
        System.out.println("============= Direct Insert Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array1);
        Sort directInsertSort = new DirectInsertSort();
        directInsertSort.sort(array1);
        SortUtil.printArray(array1);

        System.out.println("============= Binary Insert Sort ===============");
        int[] array2 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array2);
        Sort binaryInsertSort = new BinaryInsertSort();
        binaryInsertSort.sort(array2);
        SortUtil.printArray(array2);

        System.out.println("============= Shell Insert Sort ===============");
        int[] array3 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array3);
        Sort shellSort = new ShellSort();
        shellSort.sort(array3);
        SortUtil.printArray(array3);
    }
}
