package net.ninini.scaffold.infrastructure.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BaseEvent
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/27 22:45
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event<T> {

    String messageId;

    String messageTopic;

    String messageTag;

    EventChannel messageChannel;

    String publisher;

    T value;
}
