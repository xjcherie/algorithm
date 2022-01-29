package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 **/
public class ImplementTriePrefixTree {
    private Set<String> set = new HashSet<>();

    public ImplementTriePrefixTree() {

    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String s : set) {
            if (s.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
