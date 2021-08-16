package net.ninini.scaffold.interfaces.assembler;

import com.google.common.collect.Lists;
import net.ninini.scaffold.domain.democase.entity.bo.DemoBO;
import net.ninini.scaffold.domain.democase.entity.vo.DemoVO;
import net.ninini.scaffold.interfaces.dto.DemoDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @ClassName: DemoAssembler
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/25 17:31
 * @Version 1.0.0
 */
public class DemoAssembler {

    public static DemoBO dtoToBO(DemoDTO dto) {
        DemoBO demoBO = DemoBO.builder().build();
        BeanUtils.copyProperties(dto, demoBO);
        return demoBO;
    }

    @Deprecated
    public static DemoVO boToVO(DemoBO demoBO) {
        DemoVO demoVO = DemoVO.builder().build();
        BeanUtils.copyProperties(demoBO, demoVO);
        return demoVO;
    }

    @Deprecated
    public static List<DemoVO> batchBOToVO(List<DemoBO> bos) {
        List<DemoVO> vos = Lists.newArrayList();
        for (DemoBO demoBO : bos) {
            DemoVO demoVO = DemoVO.builder().build();
            BeanUtils.copyProperties(demoBO, demoVO);
            vos.add(demoVO);
        }
        return vos;
    }
}
