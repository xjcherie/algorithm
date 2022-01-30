package practice;

/**
 * Created by Cherie on 2021/11/29
 * 我有n个数，生成一个list 集合，比如1,2,3最后生成：1,2,3,12,13,23,123
 **/
public class test {

//    static List<Long> list = new ArrayList<>();
//
//    public static void main(String[] args) {
//        int[] array = init();
//
//        Stopwatch sw1 = Stopwatch.createStarted();
//        for (int i = 0; i < array.length; i++) {
//            list.add((long) array[i]);
//            traverse(array[i], i + 1, array);
//        }
//        sw1.stop();
//        System.out.println(sw1.elapsed(TimeUnit.SECONDS));
//        System.out.println(list.size());
//    }
//
//    private static int[] init() {
//        int[] array = new int[25];
//        for (int i = 0; i < 25; i++) {
//            array[i] = i;
//        }
//        return array;
//    }
//
//    private static void traverse(long basic, int index, int[] array) {
//        if (index >= array.length) {
//            return;
//        }
//        for (int i = index; i < array.length; i++) {
//            long newDigit = basic * 10 + array[i];
//            list.add(newDigit);
//            traverse(newDigit, i + 1, array);
//        }
//    }

}
