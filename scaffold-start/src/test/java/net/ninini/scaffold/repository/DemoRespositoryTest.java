package net.ninini.scaffold.repository;

import net.ninini.scaffold.repository.facade.IDemoRepository;
import net.ninini.scaffold.repository.mapper.DemoMapper;
import net.ninini.scaffold.repository.po.DemoPO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.BDDMockito.given;

/**
 * @ClassName: DemoRespositoryTest
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/7/6 12:28
 * @Version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@PropertySource("classpath:application-local.yml")
public class DemoRespositoryTest {

    @Autowired
    private IDemoRepository demoRespository;

    @MockBean
    DemoMapper demoMapper;

    @Test
    @Rollback
    public void testDao() {
        given(demoMapper.insert(anyObject())).willReturn(1);
        int n = demoRespository.saveDemo(new DemoPO());
        Assert.assertEquals(n, 1);
    }
}
