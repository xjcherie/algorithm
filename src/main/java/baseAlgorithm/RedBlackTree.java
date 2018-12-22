package baseAlgorithm;

/**
 * create by cherie on 2018/7/25.
 */
public class RedBlackTree {

    enum Color {
        RED("RED"),
        BLACK("BALCK");

        private String value;

        Color(String value) {
            this.value = value;
        }
    }

    class RBTreeNode {

        private int key;

        private int data;

        private Color color;
    }

    public static void main(String[] args) {

    }

}
