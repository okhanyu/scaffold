package net.ninini.scaffold.infrastructure.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @ClassName: PageConver
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/29 17:50
 * @Version 1.0.0
 */
public class PageAssembler {

    private static String[] ignoreList = {
            "records"
    };

    public static <K, T> PageData<T> convert(PageData<K> source, List<T> target) {
        PageData<T> pageData = new PageData();
        BeanUtils.copyProperties(source, pageData, ignoreList);
        pageData.setRecords(target);
        return pageData;
    }

    public static <K extends IPage<T>, T> PageData<T> convertToPageData(K source) {
        PageData<T> pageData = new PageData();
        BeanUtils.copyProperties(source, pageData);
        return pageData;
    }

    public static <K extends IPage, T> PageData<T> convert(K source, List<T> target) {
        PageData<T> pageData = new PageData();
        BeanUtils.copyProperties(source, pageData, ignoreList);
        pageData.setRecords(target);
        return pageData;
    }

}
