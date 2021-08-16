package net.ninini.scaffold.domain.democase.factory;

import com.google.common.collect.Lists;
import net.ninini.scaffold.domain.democase.entity.bo.DemoBO;
import net.ninini.scaffold.repository.po.DemoPO;

import java.util.List;

/**
 * @ClassName: DemoEntityFactory
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/28 19:45
 * @Version 1.0.0
 */
public class DemoEntityFactory {

    public static DemoBO poToBO(DemoPO demoPO) {
        return DemoBO.builder().a(demoPO.getId())
                .b(demoPO.getParentCode())
                .c(demoPO.getType())
                .d(demoPO.getSort()).build();
    }

    public static DemoPO boToPO(DemoBO demoBO) {
        return DemoPO.builder().id(demoBO.getA())
                .parentCode(demoBO.getB())
                .type(demoBO.getC())
                .sort(demoBO.getD()).build();
    }

    public static List<DemoBO> batchPOToBO(List<DemoPO> pos) {
        // 建议不要判NULL，如果pos为空直接返回空集合，空集合返回可以减少上层无意义判NULL
        List<DemoBO> bos = Lists.newArrayList();
        for (DemoPO demoPO : pos) {
            bos.add(poToBO(demoPO));
        }
        return bos;
    }

}
