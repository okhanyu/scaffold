package net.ninini.scaffold.infrastructure.event.subscribe;

import net.ninini.scaffold.infrastructure.event.bus.DefaultEventBus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: DefaultSubscriber
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/7/5 20:26
 * @Version 1.0.0
 */

@Component("defaultSubscriber")
public abstract class DefaultSubscriber implements ISubscriber{

    @Resource(name = "defaultEventBus")
    public DefaultEventBus bus;

}
