package practice;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author: Cherie
 * @Date: 2022-08-11
 * Sort Book Chapters
 */
public class SortBookChapters {

    private static final String SPLIT_REGEX = "\\.";

    /**
     * Constructing a sorting method
     */
    public List<String> sortChapters(List<String> chapters) {
        chapters.sort(SortBookChapters::compare);
        return chapters;
    }

    private static int compare(String chapter1, String chapter2) {
        String[] sections1 = chapter1.split(SPLIT_REGEX);
        String[] sections2 = chapter2.split(SPLIT_REGEX);
        for (int i = 0; i < Math.min(sections1.length, sections2.length); i++) {
            int section1 = Integer.parseInt(sections1[i]);
            int section2 = Integer.parseInt(sections2[i]);
            if (section1 > section2) {
                return 1;
            } else if (section1 < section2) {
                return -1;
            }
        }
        return sections1.length < sections2.length ? 1 : -1;
    }

    /**
     * Sorting using ASCII sequences
     */
    public List<String> sortChapters2(List<String> chapters) {
        LinkedHashMap<String, String> sourceMap = new LinkedHashMap<>();
        for (String chapter : chapters) {
            String asciiString = genAsciiChapter(chapter);
            sourceMap.put(asciiString, chapter);
        }

        Map<String, String> newMap = sourceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<String> result = new ArrayList<>();
        newMap.forEach((k, v) -> result.add(v));
        return result;
    }

    private String genAsciiChapter(String s) {
        StringBuilder sb = new StringBuilder();
        for (String chapter : s.split(SPLIT_REGEX)) {
            long num = 0;
            for (int i = 0; i < chapter.toCharArray().length; i++) {
                num += (long) chapter.charAt(i) * Math.pow(10, i);
            }
            sb.append(num);
        }
        return sb.toString();
    }


    @Test
    public void test() {
        List<String> data = new ArrayList<>();
        data.add("1.1.1");
        data.add("1.3.3");
        data.add("1.12.3");
        data.add("1.2.1");
        data.add("1.1.2");

        List<String> ans = new ArrayList<>();
        ans.add("1.1.1");
        ans.add("1.1.2");
        ans.add("1.2.1");
        ans.add("1.3.3");
        ans.add("1.12.3");

        assertThat(sortChapters(data), equalTo(ans));
    }

}
