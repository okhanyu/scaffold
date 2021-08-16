package net.ninini.scaffold.domain.democase.service;

import net.ninini.scaffold.domain.democase.entity.bo.DemoBO;
import net.ninini.scaffold.infrastructure.page.PageDTO;
import net.ninini.scaffold.infrastructure.page.PageData;

/**
 * @ClassName: DemoDomain
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/25 18:08
 * @Version 1.0.0
 */
public interface DemoDomain {

    PageData<DemoBO> startDemo(PageDTO page , DemoBO demoBO);
}
