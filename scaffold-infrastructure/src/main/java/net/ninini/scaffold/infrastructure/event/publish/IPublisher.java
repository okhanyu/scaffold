package net.ninini.scaffold.infrastructure.event.publish;

import net.ninini.scaffold.infrastructure.event.Event;

/**
 * @ClassName: IPublisher
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/27 23:20
 * @Version 1.0.0
 */
public interface IPublisher {

    void publish(Event<?>... events);
}
