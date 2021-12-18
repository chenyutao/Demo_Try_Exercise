package concurrent.read_write;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: chenyutao
 * @date: 2021/12/6 1:05 下午
 */
public class BaseByReentryWriteReadLock implements AbstractCache{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void write() throws InterruptedException {
        lock.writeLock().lock();
        try{
            doWrite();
        }finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void read() throws InterruptedException {
        lock.readLock().lock();
        try{
            doWrite();
        }finally {
            lock.readLock().unlock();
        }
    }

}
