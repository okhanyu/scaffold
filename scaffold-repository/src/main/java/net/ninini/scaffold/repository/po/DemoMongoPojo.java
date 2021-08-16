package net.ninini.scaffold.repository.po;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TestPojo
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/22 20:27
 * @Version 1.0.0
 */

@Document(collection = "user_learning_record")
@Getter
@Setter
public class DemoMongoPojo {
    /**
     * 书或课pid
     */
//	@Indexed(name = "pid", background = true)
    private String pid;

    /**
     * 书或课名
     */
    private String title;

    /**
     * 类型 0:听书 1:课堂 2:舰长免费故事
     */
//	@Indexed(name = "type", background = true)
    private int type;

    /**
     * 用户手机
     */
//	@Indexed(name = "userPid", background = true)
    private String userPid;

    /**
     * 学习进度
     */
    private String point;

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 更新时间
     */
    private Date updateTime = new Date();

    /**
     * 已完全学习音频列表即音频进度达到百分之百
     */
    private Map<String, Object> audioLearningCompleteMap = new HashMap<>();

    /**
     * 已经完全学习视频列表即视频进度达到百分之百
     */
    private Map<String, Object> videoLearningCompleteMap = new HashMap<>();

    /**
     * 部分学学习音频列表即学习进度未达到百分之百
     */
    private Map<String, Object> audioLearningPartMap = new HashMap<>();

    /**
     * 部分视频学习进度
     */
    private Map<String, Object> videoLearningPartMap = new HashMap<>();

}
