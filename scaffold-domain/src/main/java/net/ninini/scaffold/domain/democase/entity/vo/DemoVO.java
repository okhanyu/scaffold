package net.ninini.scaffold.domain.democase.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: DemoVO
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/25 18:06
 * @Version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoVO {

    private String d;

    private String f;

    private String c;
}
