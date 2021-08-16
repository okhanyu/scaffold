package net.ninini.scaffold.infrastructure.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: PageVO
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/30 15:45
 * @Version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> {

    private List<T> records;
    private long total;
    private long size;
    private long current;
}
