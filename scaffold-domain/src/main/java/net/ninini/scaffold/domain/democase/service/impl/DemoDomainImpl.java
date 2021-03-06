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
     * @description todo ??????demo???domain??????
     * @param: demoBO
     * @return: net.ninini.scaffold.domain.democase.entity.bo.DemoBO
     * @author HanYu
     * @updateTime 2021/6/29 14:51
     */
    @Override
    public PageData<DemoBO> startDemo(PageDTO pageDTO, DemoBO demoBO) {
//        // ????????????
//        ResponseBuilder<String> r = demoRemoteClient.demo("test");
//        log.info("r {}", r);
        if (demoBO.getA().equals("demo")) {
            // ????????????????????????????????????Controller???????????????????????????????????????
            throw new BusinessException(ResponseCode.PARAM_ERROR);
        }

        // ??????????????????????????????????????????????????????????????????
        demoBO.finish().create();
        // ??????????????????????????????
        DemoPO demoPO = DemoEntityFactory.boToPO(demoBO);
        // ??????mongo
        queryByMongo();
        // ??????redis
        queryByRedis();

        // ID?????????
        //log.info("ID?????????????????????:{}", idGenerator.getID());

        return queryByMySQL(pageDTO, demoPO);
    }


    public PageData<DemoBO> queryByMySQL(PageDTO pageDTO, DemoPO demoPO) {
        //demoRepository.saveDemo(demoPO);

        PageData<DemoPO> pos = demoRepository.getDemoByWrapper(pageDTO, demoPO);
        log.info("????????????????????? {}", pos);

        pos = demoRepository.getDemoByPage(pageDTO, demoPO);
        log.info("????????????????????? {}", pos);

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
        log.info("??????mongo??? {}", mongoTemplate.find(query, DemoMongoPojo.class));
    }

    public void queryByRedis() {
        iRedisTemplate.opsForValue().set("demoKey", 12345);
        log.info("??????redis??? {}", iRedisTemplate.opsForValue().get("demoKey"));
    }

    public void remote() {
        log.info("????????????:{}", demoRemoteClient.demo("test"));
    }
}
