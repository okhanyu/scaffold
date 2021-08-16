package net.ninini.scaffold.infrastructure.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DemoKafkaConsumer
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/30 17:23
 * @Version 1.0.0
 */
@Slf4j
@Service
public class DemoKafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void kafkaLis(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        log.info("收到kafka消息：{}", record.value());
    }
}
