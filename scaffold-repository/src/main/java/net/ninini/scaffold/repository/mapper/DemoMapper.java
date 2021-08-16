package net.ninini.scaffold.repository.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.ninini.scaffold.repository.po.DemoPO;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: TestDao
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/21 18:49
 * @Version 1.0.0
 */
@Repository
public interface DemoMapper extends BaseMapper<DemoPO> {

    // MP的多数据源标识是采用就近原则，方法最近
    @DS("data_master")
    IPage<DemoPO> getDemoPOs(IPage<DemoPO> page);

}
