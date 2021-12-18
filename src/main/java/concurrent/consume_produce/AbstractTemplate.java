package concurrent.consume_produce;

import java.util.List;
import java.util.Queue;

/**
 * @author: chenyutao
 * @date: 2021/12/2 10:00 下午
 */
public interface AbstractTemplate {

    void consume(Queue<Object> queue) throws InterruptedException;

    void produce(Queue<Object> queue, Integer maxSize) throws InterruptedException;
}
