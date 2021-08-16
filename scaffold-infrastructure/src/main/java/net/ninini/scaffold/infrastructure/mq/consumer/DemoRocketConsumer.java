package net.ninini.scaffold.infrastructure.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DemoRocketConsumer
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/30 17:21
 * @Version 1.0.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "test", consumerGroup = "h1g")
public class DemoRocketConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("收到rocket消息：{}", message);
    }
}
