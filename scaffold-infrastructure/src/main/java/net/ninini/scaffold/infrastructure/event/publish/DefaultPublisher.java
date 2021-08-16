package net.ninini.scaffold.infrastructure.event.publish;

import net.ninini.scaffold.infrastructure.event.Event;
import net.ninini.scaffold.infrastructure.event.bus.DefaultEventBus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: DefaultPublisher
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/28 00:05
 * @Version 1.0.0
 */

@Component("defaultPublisher")
public class DefaultPublisher implements IPublisher {

    @Resource(name = "defaultEventBus")
    DefaultEventBus bus;

    @Override
    public void publish(Event<?>... events) {
        for (Event<?> event :   events) {
            bus.publish(event);
        }
    }

}
