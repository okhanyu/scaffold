package net.ninini.scaffold.infrastructure.event.bus;

import net.ninini.scaffold.infrastructure.event.Event;
import net.ninini.scaffold.infrastructure.event.subscribe.ISubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName: IEventBus
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/27 23:40
 * @Version 1.0.0
 */
public abstract class IEventBus {

    // 总线名称
    private String busName;

    // 总线队列容量
    final int QUEUE_CAPACITY = 65535;

    // 总线存储队列
    private BlockingQueue<Event> queue = new ArrayBlockingQueue<Event>(QUEUE_CAPACITY);

    // 订阅者
    private List<ISubscriber> subscribers = new ArrayList<ISubscriber>();

    /**
     * @title subscribe
     * @description todo 添加订阅者
     * @param: subscriber
     * @author HanYu
     * @updateTime 2021/6/27 23:46
     */
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    /**
     * @title unSubscribe
     * @description todo 移除订阅者
     * @param: subscriber
     * @author HanYu
     * @updateTime 2021/6/27 23:46
     */
    public void unSubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    /**
     * @title publish
     * @description todo 发布消息
     * @param: event
     * @author HanYu
     * @updateTime 2021/6/28 00:11
     */
    public void publish(Event event) {
        if (queue.offer(event)) {
            // 暂时未做异常处理，后期再说
            onMessage();
        }
    }

    /**
     * @title onMessage
     * @description todo 弹出消息
     * @author HanYu
     * @updateTime 2021/6/27 23:58
     */
    public void onMessage() {
        Event event;
        while ((event = queue.poll()) != null) {
            this.onMessage(event);
        }
    }

    /**
     * @title onMessage
     * @description todo 遍历订阅者并发送消息
     * @param: event
     * @author HanYu
     * @updateTime 2021/6/27 23:58
     */
    public void onMessage(Event event) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.onMessage(event);
        }
    }

}
