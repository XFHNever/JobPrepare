package Algorithm.sort.select;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/5.
 *
 * 核心思想：思想与体育比赛类似。 首先将n个数据元素两两分组，分别按关键字进行比较，得到n／2个比较的优胜者(关键字小者)，作为第一步比较的结果保留下来，
 * 然后对这n／2个数据元素再两两分组，分别按关键字进行比较，…，如此重复，直到选出一个关键字最小的数据元素为止。
 *
 *
 *
 */
public class TournamentSort implements Sort {
    @Override
    public void sort(int[] array) {
        //TODO
    }
}

class WinnerTree {
    int maxSize;
    int n;
    int lowExt;
    int offset;
    int[] winners;
    int[] players;

    public WinnerTree(int size) {

    }
    public void initial(){

    }

    public void update() {

    }

}
