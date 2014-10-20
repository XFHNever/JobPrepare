package Algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soft on 2014/10/20.
 */
public class FindKMaxInArrays {
    public static void main(String arg[]) {
        FindKMaxInArrays findKMaxInArrays = new FindKMaxInArrays();
        int[] array1 = {40,23,12,5,4,3,2,1};
        int[] array2 = {42,24};
        int[] array3 = {44,32,21,5,4,3,2,1};
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(array1);
        list.add(array2);
        list.add(array3);

        findKMaxInArrays.findK(10, list);
    }

    private void findK(int K, List<int[]> list) {
        int size = list.size();
        Node[] nodes = new Node[size];

        for (int i=0; i< size; i++) {
            Node node = new Node();
            node.group = i;
            node.index = 0;
            node.value = list.get(i)[0];
            nodes[i] = node;
        }

        MaxHeap heap = new MaxHeap(size+2, nodes);
        for (int i=(size-2)/2; i>=0; i--) {
            heap.siftDown(i, size-1);
        }

        while (K>0) {
            Node top = heap.nodes[0];
            System.out.print(top.value + "\t");

            Node newNode = new Node();
            newNode.group = top.group;
            newNode.index = top.index + 1;
            if (top.index >= list.get(top.group).length -1) {
                newNode.value = Integer.MIN_VALUE;
            } else {
                newNode.value = list.get(newNode.group)[newNode.index];
            }

            heap.nodes[0] = newNode;
            heap.siftDown(0, size-1);
            K--;
        }

    }
    class Node {
        int value;
        int group;
        int index;
    }

    class MaxHeap {
        Node[] nodes;
        int currentSize;
        int maxSize;

        public MaxHeap(int length, Node[] array) {
            this.maxSize = length;
            this.currentSize = array.length;
            this.nodes = array;
        }

        public void siftDown(int start, int end) {
            int i = start;
            int j = 2*i + 1;
            Node tmp = nodes[start];

            while (j <= end) {
                if (j < end && nodes[j].value < nodes[j+1].value) {
                    j++;
                }

                if (tmp.value >= nodes[j].value) {
                    break;
                } else {
                    nodes[i] = nodes[j];
                    i = j;
                    j = 2*i + 1;
                }
            }

            nodes[i] = tmp;
        }
    }

    class LoserTree {
        int size;
        int[] b, ls;


        public LoserTree(List<int[]> list) {
            this.size = list.size();
            b = new int[size + 1];
            ls = new int[2*size];
        }

        public void adjust(int s) {
            int i,j;

            for (j = (size+s)/2; j>0; j/=2) {
                if (b[s] > b[ls[j]]) {
                    swap(ls, s, j);
                }
            }
            ls[0] = s;
        }

        public void merge() {

        }

        public void createLoserTree() {
            int i=0;
            b[size] = Integer.MIN_VALUE;
            for (i = 1; i<size; i++) {
                ls[i] = size;
            }

            for (i=size-1; i>=0; i--) {
                adjust(i);
            }
        }

        private void swap(int[] array, int left, int right) {
            int tem = array[left];
            array[left] = array[right];
            array[right] = tem;
        }
    }
}
