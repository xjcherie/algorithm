package practice;

/**
 * create by cherie on 2018/7/31.
 */
public class WordSearch {

//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.

//    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
//        boolean result = exist(board, word);
//        System.out.println(result);
//    }
//
//    private static boolean exist(char[][] board, String word) {
//        if (word.equals("") || board == null || board.length == 0) {
//            return false;
//        }
//        char[] searchWords = word.toCharArray();
//        int h, v = 0;
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        boolean result = false;
//        for (h = 0; h < board.length; h++) {
//            for (v = 0; v < board[h].length; v++) {
//                if (board[h][v] == searchWords[0]) {
//                    Set<Integer> set = new HashSet<>();
//                    set.add(v);
//                    map.put(h, set);
//                    result = true;
//                }
//            }
//        }
//        if (!result) {
//            return false;
//        }
//        for (int i = 1; i < searchWords.length; i++) {
//            char searchWord = searchWords[i];
//            if (exist(searchWord, board, map, h)) {
//                continue;
//            }
//            if (h < board.length - 1) {
//                if (!exist(searchWord, board, map, h)) {
//                    continue;
//                }
//            }
//            for (int m = 0; m < board.length; m++) {
//                if (v < board[m].length) {
//                    Set<Integer> set = map.computeIfAbsent(h, k -> new HashSet<>());
//                    if (!set.contains(m)) {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        return false;
//    }
//
//    private static boolean exist(char word, char[][] board, Map<Integer, Set<Integer>> map, int h) {
//        if (h=0){
//
//        }
//        for (int j = 0; j < board[h - 1].length; j++) {
//            if (word == board[h][j]) {
//                Set<Integer> set = map.computeIfAbsent(h, k -> new HashSet<>());
//                if (!set.contains(j)) {
//                    set.add(j);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


    public static void main(String[] args) {
        Long i = 1L;
        System.out.println(i.hashCode());
        Long h = 11L;
        System.out.println(h.hashCode());


        String str = "haha";
        System.out.println(str.hashCode());


        Boolean flag = true;
        System.out.println(flag.hashCode());
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
    }
}
