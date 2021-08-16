package net.ninini.scaffold.repository.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @ClassName: DemoPO
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/28 14:44
 * @Version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "t_trace")
@Document(collection = "user_learning_record")
public class DemoPO {

    @TableId(value = "id")
    private String id;

    @TableField(value = "type")
    private String type;

    @TableField(value = "parent_code")
    private String parentCode;

    @TableField(value = "sort")
    private int sort;

    @TableField(value = "sort", exist = false)
    private int test;

    @TableField(value = "create_time")
    private Date createTime;
}
