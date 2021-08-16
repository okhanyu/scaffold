package net.ninini.scaffold.infrastructure.mq.publisher;

import net.ninini.scaffold.infrastructure.event.Event;
import net.ninini.scaffold.infrastructure.event.EventChannel;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MQPublisher
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/7/2 18:36
 * @Version 1.0.0
 */

@Component
@Slf4j
public class MQPublisher {

    RocketMQTemplate rocketMQTemplate;

    KafkaTemplate kafkaTemplate;

    @Autowired
    public MQPublisher(RocketMQTemplate rocketMQTemplate, KafkaTemplate kafkaTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(Event<?>... events) {
        for (Event<?> event : events) {
            if (event.getMessageChannel().equals(EventChannel.kafka)) {
                log.info("kafka send message to {} and msg is {}", event.getMessageTopic(), event.getValue());
                kafkaTemplate.send(event.getMessageTopic(), event.getValue());
            }
            if (event.getMessageChannel().equals(EventChannel.rocket)) {
                log.info("rocket send message to {} and msg is {}", event.getMessageTopic(), event.getValue());
                rocketMQTemplate.sendOneWay(event.getMessageTopic(), event.getValue());
                // rocketMQTemplate.send(event.getMessageTopic(), MessageBuilder.withPayload("消息").build());
            }
        }
    }
}
