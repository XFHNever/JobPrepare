package Algorithm.other;

/**
 * Created by never on 2014/10/16.
 */
public class MoreFixedValue {
    public static int count =0;
    public static void main(String args[]) {
        MoreFixedValue fixedValue = new MoreFixedValue();
        int[] flag = new int[20];
        fixedValue.find(8, 20, flag, 20);
        System.out.println(count);
    }

    private void find(int m, int n, int[] flag, int length) {
        if (m<=0 || n<=0) {
            return;
        }

        if (n*(n+1) < m) {      //ʣ�����е����ĺͶ�<m���������ҡ�
            return;
        }

        if (m> n) {
            //����n
            flag[n-1] = 1;
            find(m-n, n-1, flag, length);

            //������n
            flag[n-1] = 0;
            find(m, n-1, flag, length);
        } else {
            flag[m-1] = 1;
            for (int i=0; i<length; i++) {
                if (flag[i] == 1)
                    System.out.print((i+1) + " ");
            }
            System.out.println();

            //������n��������
            flag[m-1] = 0;
            find(m, m-1, flag, length);
        }
    }
}
