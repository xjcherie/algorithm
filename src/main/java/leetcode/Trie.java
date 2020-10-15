package leetcode;

import java.util.*;

/**
 * Created by Cherie on 2020/05/14
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * todo
 **/
public class Trie {
    private Set<String> set = new HashSet<>();

    public Trie() {

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




