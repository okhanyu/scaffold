package net.ninini.scaffold.infrastructure.event.subscribe;

import net.ninini.scaffold.infrastructure.event.Event;

/**
 * @ClassName: ISubscribe
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/27 22:56
 * @Version 1.0.0
 */
public interface ISubscriber {

    void onMessage(Event event);

}
