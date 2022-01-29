package practice;

/**
 * Created by Cherie on 2021/08/20
 **/
public class WordCount {

    public static void main(String[] args) {
        String str = "hello world";
//        if (str.length() == 0) return 0;

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        count++;
        System.out.println(count);
    }

}
