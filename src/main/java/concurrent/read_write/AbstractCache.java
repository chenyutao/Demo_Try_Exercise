package concurrent.read_write;

/**
 * @author: chenyutao
 * @date: 2021/12/2 10:38 下午
 */
public interface AbstractCache {
    void write() throws InterruptedException;
    void read()  throws InterruptedException;

    default void doRead(){}
    default void doWrite(){}


}
