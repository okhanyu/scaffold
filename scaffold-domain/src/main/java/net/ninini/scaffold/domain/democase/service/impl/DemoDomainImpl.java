package net.ninini.scaffold.domain.democase.service.impl;

import net.ninini.scaffold.domain.democase.entity.bo.DemoBO;
import net.ninini.scaffold.domain.democase.factory.DemoEntityFactory;
import net.ninini.scaffold.domain.democase.service.DemoDomain;
import net.ninini.scaffold.infrastructure.page.PageAssembler;
import net.ninini.scaffold.infrastructure.page.PageDTO;
import net.ninini.scaffold.infrastructure.page.PageData;
import net.ninini.scaffold.infrastructure.remote.DemoRemoteClient;
import net.ninini.scaffold.repository.facade.IDemoRepository;
import net.ninini.scaffold.repository.po.DemoMongoPojo;
import net.ninini.scaffold.repository.po.DemoPO;
import lombok.extern.slf4j.Slf4j;
import net.ninini.starter.common.id.IDGenerator;
import net.ninini.starter.exception.info.BusinessException;
import net.ninini.starter.redis.core.template.IRedisTemplate;
import net.ninini.starter.response.code.ResponseCode;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: DemoDomainImpl
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/25 18:08
 * @Version 1.0.0
 */
@Service
@Slf4j
public class DemoDomainImpl implements DemoDomain {

    MongoTemplate mongoTemplate;

    RocketMQTemplate rocketMQTemplate;

    KafkaTemplate<String, Object> kafkaTemplate;

    IRedisTemplate iRedisTemplate;

    DemoRemoteClient demoRemoteClient;

    IDemoRepository demoRepository;

    IDGenerator idGenerator;

    @Autowired
    public DemoDomainImpl(MongoTemplate mongoTemplate, RocketMQTemplate rocketMQTemplate, KafkaTemplate<String, Object> kafkaTemplate, IRedisTemplate iRedisTemplate, DemoRemoteClient demoRemoteClient, IDemoRepository demoRepository, IDGenerator idGenerator) {
        this.mongoTemplate = mongoTemplate;
        this.rocketMQTemplate = rocketMQTemplate;
        this.kafkaTemplate = kafkaTemplate;
        this.iRedisTemplate = iRedisTemplate;
        this.demoRemoteClient = demoRemoteClient;
        this.demoRepository = demoRepository;
        this.idGenerator = idGenerator;
    }

    /**
     * @title startDemo
     * @description todo 开始demo的domain处理
     * @param: demoBO
     * @return: net.ninini.scaffold.domain.democase.entity.bo.DemoBO
     * @author HanYu
     * @updateTime 2021/6/29 14:51
     */
    @Override
    public PageData<DemoBO> startDemo(PageDTO pageDTO, DemoBO demoBO) {
//        // 远程调用
//        ResponseBuilder<String> r = demoRemoteClient.demo("test");
//        log.info("r {}", r);
        if (demoBO.getA().equals("demo")) {
            // 已经使用全局异常处理，到Controller层会自动被捕获后构造响应体
            throw new BusinessException(ResponseCode.PARAM_ERROR);
        }

        // 使用充血模型，实体自身行为，就放在实体中完成
        demoBO.finish().create();
        // 调用仓储层进行持久化
        DemoPO demoPO = DemoEntityFactory.boToPO(demoBO);
        // 查询mongo
        queryByMongo();
        // 查询redis
        queryByRedis();

        // ID生成器
        //log.info("ID生成器远程调用:{}", idGenerator.getID());

        return queryByMySQL(pageDTO, demoPO);
    }


    public PageData<DemoBO> queryByMySQL(PageDTO pageDTO, DemoPO demoPO) {
        //demoRepository.saveDemo(demoPO);

        PageData<DemoPO> pos = demoRepository.getDemoByWrapper(pageDTO, demoPO);
        log.info("第一次分页查询 {}", pos);

        pos = demoRepository.getDemoByPage(pageDTO, demoPO);
        log.info("第二次分页查询 {}", pos);

        demoPO = new DemoPO();
        demoPO.setId("8888");
        demoPO.setParentCode("2222");
        demoPO.setSort(3333);
        demoPO.setType("0");
        demoPO.setTest(1);
        demoPO.setCreateTime(new Date());

        int i = demoRepository.saveDemo(demoPO);


        PageData<DemoBO> pageData = PageAssembler.convert(pos, DemoEntityFactory.batchPOToBO(pos.getRecords()));
        return pageData;
    }

    public void queryByMongo() {
        Criteria criteria = new Criteria();
        criteria.and("pid").is("183819552214355968");
        Query query = new Query(criteria);
        log.info("查询mongo： {}", mongoTemplate.find(query, DemoMongoPojo.class));
    }

    public void queryByRedis() {
        iRedisTemplate.opsForValue().set("demoKey", 12345);
        log.info("查询redis： {}", iRedisTemplate.opsForValue().get("demoKey"));
    }

    public void remote() {
        log.info("远程调用:{}", demoRemoteClient.demo("test"));
    }
}
