package baseAlgorithm;

/**
 * create by cherie on 2018/10/1.
 * 斐波那契数列
 * 每一项与下一项的比值，越来越接近0.618
 */
public class Fibonacci {

    public static void main(String[] args) {
        double[] arrays = new double[100];
        for (int i = 0; i < 100; i++) {
            if (i > 1) {
                arrays[i] = arrays[i - 1] + arrays[i - 2];
            } else {
                arrays[i] = 1;
            }
            System.out.println(arrays[i]);
        }

        for (int i = 0; i < 100; i++) {
            if (i < 99) {
                System.out.println(arrays[i] / arrays[i + 1]);
            }
        }
    }

}
