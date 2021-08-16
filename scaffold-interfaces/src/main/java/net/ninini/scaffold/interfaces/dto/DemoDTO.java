package net.ninini.scaffold.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassName: DemoDto
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/25 17:30
 * @Version 1.0.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoDTO {

    @NotEmpty
    private String a;

    @Size(max = 10, min = 2)
    private String b;

    @Length(min = 10, max = 20)
    private String c;

    @Max(value = 10, message = "数字不能大于10")
    private int d;

}
