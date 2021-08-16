package net.ninini.scaffold.repository.facade.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.ninini.scaffold.infrastructure.page.PageAssembler;
import net.ninini.scaffold.infrastructure.page.PageDTO;
import net.ninini.scaffold.infrastructure.page.PageData;
import net.ninini.scaffold.repository.mapper.DemoMapper;
import net.ninini.scaffold.repository.facade.IDemoRepository;
import net.ninini.scaffold.repository.po.DemoPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: DemoRepositoryImpl
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/28 14:46
 * @Version 1.0.0
 */
@Repository
public class DemoRepository implements IDemoRepository {

    DemoMapper demoMapper;

    @Autowired
    public DemoRepository(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
    public PageData<DemoPO> getDemoByPage(PageDTO pageDTO, DemoPO demoPO) {
        // 分页查询
        IPage<DemoPO> page = new Page(pageDTO.getCurrent(), pageDTO.getSize());
        // page.setSearchCount(false);
        // IPage<DemoPO> pos = demoMapper.getDemoPOs(page);
        demoMapper.getDemoPOs(page);
        return PageAssembler.convertToPageData(page);
    }

    @Override
    public PageData<DemoPO> getDemoByWrapper(PageDTO pageDTO, DemoPO demoPO) {
        QueryWrapper<DemoPO> wrapper = Wrappers.query();
        wrapper.eq("parent_code", demoPO.getParentCode());
        IPage<DemoPO> page = new Page(pageDTO.getCurrent(), pageDTO.getSize());
        page = demoMapper.selectPage(page, wrapper);
        return PageAssembler.convertToPageData(page);
    }


    @Override
    @Transactional
    public int saveDemo(DemoPO demoPO) {
        int i = demoMapper.insert(demoPO);
        //throw new RuntimeException();
        return i;
    }
}
