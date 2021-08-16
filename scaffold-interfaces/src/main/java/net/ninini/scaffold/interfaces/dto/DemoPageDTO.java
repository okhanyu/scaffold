package net.ninini.scaffold.interfaces.dto;

import net.ninini.scaffold.infrastructure.page.PageDTO;
import lombok.Data;

import javax.validation.Valid;

/**
 * @ClassName: DemoPageDto
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/30 17:52
 * @Version 1.0.0
 */
@Data
public class DemoPageDTO {

    @Valid
    DemoDTO demoDTO;

    PageDTO pageDTO;
}
