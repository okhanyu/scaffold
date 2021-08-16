package net.ninini.scaffold.infrastructure.remote;

import net.ninini.scaffold.infrastructure.remote.fallback.DemoFeignFallbackFactory;
import net.ninini.starter.response.builder.ResponseBuilder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: DemoRemote
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/28 00:30
 * @Version 1.0.0
 */
@FeignClient(name="demo",url = "http://10.1.1.2:802",fallbackFactory = DemoFeignFallbackFactory.class)
public interface DemoRemoteClient {

    @GetMapping("/demo/b")
    ResponseBuilder<String> demo(@RequestParam("key") String key);

}
