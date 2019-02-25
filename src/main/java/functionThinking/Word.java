package functionThinking;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by cherie on 2018/12/22.
 * 函数式编程，单词查找
 */
public class Word {

    static String WORD = "There are many who fear that in the future, AI will do more and more of the jobs done by humans, leaving us without meaningful work.";

    static String REGEX = "\\w+";

    private static Set<String> NON_WORDS = new HashSet<String>() {{
        add("the");
        add("and");
        add("of");
        add("to");
        add("a");
        add("i");
        add("it");
        add("in");
        add("or");
        add("is");
        add("d");
        add("s");
        add("as");
        add("so");
        add("but");
        add("be");
    }};

    /**
     * 普通实现方式
     */
    public static class SimpleWord {

        static Map wordFreq(String words) {
            TreeMap<String, Integer> wordMap = new TreeMap<>();
            Matcher m = Pattern.compile(REGEX).matcher(words);
            while (m.find()) {
                String word = m.group().toLowerCase();
                if (!NON_WORDS.contains(word)) {
                    if (wordMap.get(word) == null) {
                        wordMap.put(word, 1);
                    } else {
                        wordMap.put(word, wordMap.get(word) + 1);
                    }
                }
            }
            return wordMap;
        }
    }

    /**
     * 函数式编程的类
     */
    public static class FunctionWord {

        private static List<String> regexToList(String words, String regex) {
            List<String> wordList = new ArrayList<>();
            Matcher m = Pattern.compile(regex).matcher(words);
            while (m.find())
                wordList.add(m.group());
            return wordList;
        }

        static Map wordFreq(String words) {
            TreeMap<String, Integer> wordMap = new TreeMap<>();
            regexToList(words, REGEX)
                    .stream()
                    .map(String::toLowerCase)
                    .filter(w -> !NON_WORDS.contains(w))
                    .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));
            return wordMap;
        }

        public static void main(String[] args) {

            long time = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                wordFreq(WORD);
            }
            System.out.println(System.currentTimeMillis() - time);

            Map wordMap = wordFreq(WORD);
            System.out.println(wordMap);
        }
    }

    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            SimpleWord.wordFreq(WORD);
        }

//        for (int i = 0; i < 10000; i++) {
//            FunctionWord.wordFreq(WORD);
//        }
//
        System.out.println(System.currentTimeMillis() - time);
    }

}
