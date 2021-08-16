package net.ninini.scaffold.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import net.ninini.scaffold.domain.democase.entity.bo.DemoBO;
import net.ninini.scaffold.infrastructure.page.PageData;
import net.ninini.scaffold.interfaces.application.DemoApplication;
import net.ninini.scaffold.interfaces.dto.DemoPageDTO;
import net.ninini.starter.exception.info.BusinessException;
import net.ninini.starter.response.builder.ResponseBuilder;
import net.ninini.starter.response.code.ResponseCode;
import net.ninini.starter.validate.BindingResultAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: DemoApi
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/6/18 22:22
 * @Version 1.0.0
 */

@RestController
@Slf4j
public class DemoController extends BaseApiController {

    DemoApplication demoApplication;


    @Autowired
    public DemoController(DemoApplication demoApplication) {
        this.demoApplication = demoApplication;
    }

    /**
     * @title demoA
     * @description todo 示例A
     * @param: pageDTO
     * @param: demoDTO
     * @param: bindingResult
     * @return: net.ninini.starter.response.builder.ResponseBuilder<net.ninini.scaffold.infrastructure.page.PageData<net.ninini.scaffold.domain.democase.entity.bo.DemoBO>>
     * @author HanYu
     * @updateTime 2021/6/30 16:47
     */
    @PostMapping("/demo/a")
    public ResponseBuilder<PageData<DemoBO>> demoA(@Validated @RequestBody DemoPageDTO demoPageDTO, BindingResult bindingResult) {
        BindingResultAssert.checkParam(bindingResult);
        return ResponseBuilder.success(
                demoApplication.demoApplicationFunc(demoPageDTO.getPageDTO(), demoPageDTO.getDemoDTO())
        );
    }

    @GetMapping("/demo/b")
    public ResponseBuilder<String> demoB(@RequestParam("key") String key) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new BusinessException(ResponseCode.PARAM_ERROR);
        //return ResponseBuilder.success("i'm res object");
    }

    @GetMapping("/demo/c")
    public ResponseEntity<String> demoC(@RequestParam("key") String key) {
        return ResponseEntity.ok("i'm res object");
    }

    @GetMapping("/demo/d")
    public ResponseEntity<String> demoD(@RequestParam("key") String key) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("key", "value");
        return new ResponseEntity("i'm res 400 object", headers, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/demo/e")
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "i'm error message")
    public ResponseBuilder<String> demoE(@RequestParam("key") String key) {
        return ResponseBuilder.success();
    }

    @GetMapping("/demo/f")
    public ResponseEntity demoF(@RequestParam("key") String key) {
        return ResponseEntity.ok(ResponseBuilder.success("i'm res object"));
    }

    @GetMapping("/demo/g")
    public ResponseBuilder demoG(@RequestParam("key") String key) {
        throw new BusinessException(ResponseCode.UNKNOWN_FAIL);
    }

}
