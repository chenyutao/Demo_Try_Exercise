package concurrent.read_write;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenyutao
 * @date: 2021/12/2 10:39 下午
 */
public class BaseByWaitNotify implements AbstractCache{
    private Object lock = new Object();
    private AtomicInteger reader=new AtomicInteger(0);
    private volatile  Integer writer=0;

    @Override
    public void write()  throws InterruptedException{
        synchronized (lock){
            while (reader.get()!=0 || writer!=0){
                lock.wait();
            }
            // do write
            writer++;
            this.doWrite();
            writer--;
            lock.notifyAll();
        }
    }

    @Override
    public void read()  throws InterruptedException{
        synchronized (lock){
            while (writer!=0){
                lock.wait();
            }
            reader.incrementAndGet();
            lock.notifyAll();
        }
        this.doRead();
        reader.decrementAndGet();
    }



}
