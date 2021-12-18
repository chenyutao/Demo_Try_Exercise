package concurrent.lock;

import org.junit.Test;

import java.util.concurrent.locks.StampedLock;

/**
 * @author: chenyutao
 * @date: 2021/12/2 5:44 下午
 */
public class StampedLockTest {

    @Test
    public void test() {
        StampedLock stampedLock = new StampedLock();
        long stamp = stampedLock.readLock();
        stampedLock.unlockRead(stamp);
//        stampedLock.unlockWrite();
    }

    @Test
    public void test2() {
        StampedLock stampedLock = new StampedLock();
        long stamp = stampedLock.tryOptimisticRead();
        stampedLock.validate(stamp);
        stampedLock.writeLock();
        stampedLock.readLock();


    }

}
