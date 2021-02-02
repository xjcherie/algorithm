package leetcode.amber2021;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/1/7
 * https://leetcode-cn.com/problems/word-ladder/
 **/
public class WordLadder {

    private Map<String, Integer> wordId = new HashMap<>();
    private List<List<Integer>> edge = new ArrayList<>();
    private int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    private void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }

//    private int minCount = Integer.MAX_VALUE;
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        compareWords(beginWord, endWord, wordList, 1);
//        return minCount == Integer.MAX_VALUE ? 0 : minCount;
//    }
//
//    private void compareWords(String beginWord, String endWord, List<String> wordList, int count) {
//        if (count > minCount || wordList.size() == 0) {
//            return;
//        }
//        count++;
//        for (int i = 0; i < beginWord.length(); i++) {
//            List<String> sameWords = getSameWords(beginWord, wordList, i);
//            for (String sameWord : sameWords) {
//                if (sameWord.equals(endWord)) {
//                    if (count < minCount) {
//                        minCount = count;
//                    }
//                    break;
//                }
//
//                List<String> newWordList = new ArrayList<>(wordList);
//                newWordList.remove(sameWord);
//                compareWords(sameWord, endWord, newWordList, count);
//            }
//        }
//    }
//
//    private List<String> getSameWords(String word, List<String> sourceWords, int index) {
//        String leftString = word.substring(0, index);
//        String rightString = word.substring(index + 1);
//
//        List<String> result = new ArrayList<>();
//        for (String sourceWord : sourceWords) {
//            if (leftString.equals(sourceWord.substring(0, index)) && rightString.equals(sourceWord.substring(index + 1))) {
//                result.add(sourceWord);
//            }
//        }
//        return result;
//    }

    @Test
    public void test() {
        assertThat(ladderLength("hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")), equalTo(5));
        assertThat(ladderLength("hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log")), equalTo(0));
    }
}
