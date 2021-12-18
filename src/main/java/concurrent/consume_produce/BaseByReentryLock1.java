package concurrent.consume_produce;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyutao
 * @date: 2021/12/2 9:59 下午
 */
public class BaseByReentryLock1 implements AbstractTemplate {
    ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void consume(Queue<Object> queue) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                if (!queue.isEmpty()) {
                    queue.poll();
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void produce(Queue<Object> queue, Integer maxSize) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                if (queue.size()!=maxSize) {
                    queue.add(new Object());
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }


}
