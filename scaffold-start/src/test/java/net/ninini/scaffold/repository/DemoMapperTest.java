package net.ninini.scaffold.repository;

import net.ninini.scaffold.ScaffoldApplication;
import net.ninini.scaffold.repository.mapper.DemoMapper;
import net.ninini.scaffold.repository.po.DemoPO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ClassName: DemoMapperTest
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/7/6 14:12
 * @Version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScaffoldApplication.class)
@Transactional
public class DemoMapperTest {

    @Autowired
    private DemoMapper demoMapper;

    @Test
    @Rollback
    public void testMapper() {
        // IPage<DemoPO> page = new Page();
        DemoPO demoPO = new DemoPO();
        demoPO.setId("8888");
        demoPO.setParentCode("2222");
        demoPO.setSort(3333);
        demoPO.setType("0");
        demoPO.setTest(1);
        demoPO.setCreateTime(new Date());
        int n = demoMapper.insert(demoPO);
        Assert.assertNotEquals(n,0);
    }

}
