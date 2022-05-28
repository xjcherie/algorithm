package practice;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author: Cherie
 * @Date: 2022-05-27
 */
public class QueueUsingStack<T> {

    private Stack<T> sourceStack = new Stack<>();

    private Stack<T> destStack = new Stack<>();

    public void enqueue(T t) {
        sourceStack.push(t);
    }

    public T dequeue() {
        if (destStack.isEmpty()) {
            while (sourceStack.size() > 0) {
                destStack.push(sourceStack.pop());
            }
            if (destStack.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
        }
        return destStack.pop();
    }

    @Test(expected = RuntimeException.class)
    public void test() {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertThat(queue.dequeue(), equalTo(1));
        assertThat(queue.dequeue(), equalTo(2));
        assertThat(queue.dequeue(), equalTo(3));
        queue.dequeue();
    }

}
