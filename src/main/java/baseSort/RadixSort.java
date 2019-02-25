package baseSort;

import java.util.Arrays;

/**
 * create by cherie on 2018/7/21.
 * 基于静态链的基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        Node[] dataArray = getDataArray();
        radixSort(dataArray, dataArray.length, 2, 10);
        System.out.println(Arrays.toString(dataArray));
    }

    private static void radixSort(Node[] dataArray, int n, int d, int r) {
        int i, first = 0;
        StaticQueue[] queueArray = getQueueArray();
        for (i = 0; i < n - 1; i++) {
            dataArray[i].next = i + 1;
        }

        dataArray[n - 1].next = -1;
        for (i = 0; i < d; i++) {
            distribute(dataArray, first, i, r, queueArray);
            collect(dataArray, first, r, queueArray);
        }
        addrSort(dataArray, n, first);

    }

    private static void distribute(Node[] dataArray, int first, int i, int r, StaticQueue[] queueArray) {
        int j, k, a, curr = first;
        for (j = 0; j < r; j++) {
            queueArray[j].head = -1;
        }
        while (curr != -1) {
            k = dataArray[curr].key;
            for (a = 0; a < i; a++) {
                k = k / r;
            }
            k = k % r;
            if (queueArray[k].head == -1) {
                queueArray[k].head = curr;
            } else {
                dataArray[queueArray[k].tail].next = curr;
            }
            queueArray[k].tail = curr;
            curr = dataArray[curr].next;
        }
    }

    private static void collect(Node[] dataArray, int first, int r, StaticQueue[] queueArray) {
        int last, k = 0;
        while (queueArray[k].head == -1) {
            k++;
        }
        first = queueArray[k].head;
        last = queueArray[k].tail;
        while (k < r - 1) {
            k++;
            while (k < r - 1 && queueArray[k].head == -1) {
                k++;
            }
            if (queueArray[k].head != -1) {
                dataArray[last].next = queueArray[k].head;
                last = queueArray[k].tail;

            }
        }
        dataArray[last].next = -1;
    }

    private static void addrSort(Node[] dataArray, int n, int first) {
        int i, j;
        j = first;

        Node tempNode;
        for (i = 0; i < n - 1; i++) {
            tempNode = dataArray[j];
            dataArray[j] = dataArray[i];
            dataArray[i] = tempNode;
            dataArray[i].next = j;
            j = tempNode.next;
            while (j <= i) {
                j = dataArray[j].next;
            }
        }
    }

    private static class Node {

        private int key;

        private int next;
    }

    private static class StaticQueue {

        private int head;

        private int tail;
    }

    private static Node[] getDataArray() {
        Node[] dataArray = new Node[9];
        {
            Node node = new Node();
            node.key = 97;
            dataArray[0] = node;
        }
        {
            Node node = new Node();
            node.key = 53;
            dataArray[1] = node;
        }
        {
            Node node = new Node();
            node.key = 88;
            dataArray[2] = node;
        }
        {
            Node node = new Node();
            node.key = 59;
            dataArray[3] = node;
        }
        {
            Node node = new Node();
            node.key = 26;
            dataArray[4] = node;
        }
        {
            Node node = new Node();
            node.key = 41;
            dataArray[5] = node;
        }
        {
            Node node = new Node();
            node.key = 88;
            dataArray[6] = node;
        }
        {
            Node node = new Node();
            node.key = 31;
            dataArray[7] = node;
        }
        {
            Node node = new Node();
            node.key = 22;
            dataArray[8] = node;
        }
        return dataArray;
    }

    private static StaticQueue[] getQueueArray() {
        StaticQueue[] queueArray = new StaticQueue[10];
        {
            StaticQueue queue = new StaticQueue();
            queueArray[0] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[1] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[2] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[3] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[4] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[5] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[6] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[7] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[8] = queue;
        }
        {
            StaticQueue queue = new StaticQueue();
            queueArray[9] = queue;
        }
        return queueArray;
    }
}
