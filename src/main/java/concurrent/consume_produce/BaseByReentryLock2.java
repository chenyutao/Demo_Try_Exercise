package concurrent.consume_produce;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyutao
 * @date: 2021/12/2 9:59 下午
 */
public class BaseByReentryLock2 implements AbstractTemplate {
    private ReentrantLock lock = new ReentrantLock(false);
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();

    @Override
    public void consume(Queue<Object> queue) throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                consumer.await();
            }
            queue.poll();
            producer.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void produce(Queue<Object> queue, Integer maxSize) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                producer.await();
            }
            queue.add(new Object());
            consumer.signal();
        } finally {
            lock.unlock();
        }
    }


}
