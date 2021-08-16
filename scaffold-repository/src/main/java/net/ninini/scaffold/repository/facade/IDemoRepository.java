package net.ninini.scaffold.repository.facade;

import net.ninini.scaffold.infrastructure.page.PageDTO;
import net.ninini.scaffold.infrastructure.page.PageData;
import net.ninini.scaffold.repository.po.DemoPO;

/**
 * @ClassName: DemoRespository
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/28 14:43
 * @Version 1.0.0
 */
public interface IDemoRepository {

    PageData<DemoPO> getDemoByPage(PageDTO pageDTO, DemoPO demoPO);

    PageData<DemoPO> getDemoByWrapper(PageDTO pageDTO, DemoPO demoPO);

    int saveDemo(DemoPO demoPO);
}
