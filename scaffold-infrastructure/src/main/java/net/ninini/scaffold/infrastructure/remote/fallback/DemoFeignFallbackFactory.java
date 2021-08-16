package net.ninini.scaffold.infrastructure.remote.fallback;

import net.ninini.scaffold.infrastructure.remote.DemoRemoteClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import net.ninini.starter.response.builder.ResponseBuilder;
import net.ninini.starter.response.code.ResponseCode;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FeignFallbackFactory
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/7/5 15:46
 * @Version 1.0.0
 */
@Component
@Slf4j
public class DemoFeignFallbackFactory implements FallbackFactory<DemoRemoteClient> {
    @Override
    public DemoRemoteClient create(Throwable throwable) {
        log.error("DemoRemoteClient error", throwable);
        return new DemoRemoteClient() {
            @Override
            public ResponseBuilder<String> demo(String key) {
                log.info("DemoRemoteClient降级");
                return  ResponseBuilder.fail(ResponseCode.UNKNOWN_FAIL);
            }
        };
    }
}
