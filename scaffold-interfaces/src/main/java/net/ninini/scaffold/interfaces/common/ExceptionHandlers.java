package net.ninini.scaffold.interfaces.common;

import net.ninini.starter.exception.handle.ApiControllerGlobalExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @ClassName: ExceptionHandlers
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/25 16:30
 * @Version 1.0.0
 */
@ControllerAdvice
public class ExceptionHandlers extends ApiControllerGlobalExceptionHandler {
}
