package leetcode.amber2021;

/**
 * Created by Cherie on 2020/1/7
 * https://leetcode-cn.com/problems/word-ladder/
 **/
public class WordLadder {

//    private Map<String, Set<String>> map;
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//        this.map = new HashMap<>(wordList.size());
//        map.put(beginWord, this.getRelationWords(beginWord, wordList));
//        wordList.forEach(word -> map.put(word, this.getRelationWords(word, wordList)));
//
//
//        this.traversalPath(beginWord, endWord);
//
//        return 0;
//    }
//
//    private Set<String> getRelationWords(String beginWord, List<String> wordList) {
//        char[] beginChars = beginWord.toCharArray();
//        Set<String> words = new HashSet<>();
//        wordList.forEach(word -> {
//            char[] wordChars = word.toCharArray();
//            for (int i = 0; i < wordChars.length; i++) {
//                if (beginChars[i] == wordChars[i]) {
//                    words.add(word);
//                    break;
//                }
//            }
//        });
//        return words;
//    }
//
//    private int traversalPath(String beginWord, String endWord) {
//        Set<String> relationWords = map.get(beginWord);
//        if (relationWords == null) {
//            return 0;
//        }
//        if (relationWords.contains(endWord)) {
//            return 1;
//        }
//
//        relationWords.forEach(rela);
//
//
//    }
//
//
//    @Test
//    public void test() {
//        assertThat(ladderLength("hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")), equalTo(5));
//        assertThat(ladderLength("hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log")), equalTo(0));
//    }
}
