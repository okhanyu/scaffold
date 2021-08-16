package net.ninini.scaffold.domain.democase.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @ClassName: DemoBO
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/25 17:48
 * @Version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoBO {

    private String a;

    private String b;

    private String c;

    private int d;

    private String e;

    public DemoBO finish() {
        this.c = "finish";
        this.d = 1 + 1;
        return this;
    }

    public DemoBO create() {
        // 实际使用雪花
        this.a = UUID.randomUUID().toString();
        return this;
    }
}
