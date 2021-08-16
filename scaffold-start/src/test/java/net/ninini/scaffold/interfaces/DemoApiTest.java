package net.ninini.scaffold.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ninini.scaffold.infrastructure.page.PageDTO;
import net.ninini.scaffold.interfaces.dto.DemoDTO;
import net.ninini.scaffold.interfaces.dto.DemoPageDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @ClassName: DemoControllerTes
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/7/6 12:34
 * @Version 1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@WebMvcTest(DemoController.class)
public class DemoApiTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;

    MultiValueMap<String, String> params;

    DemoPageDTO demoPageDTO;

    ObjectMapper om = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        DemoPageDTO demoPageDTO = new DemoPageDTO();
        DemoDTO demoDTO = new DemoDTO();
        PageDTO pageDTO = new PageDTO();
        demoPageDTO.setDemoDTO(demoDTO);
        demoPageDTO.setPageDTO(pageDTO);
        this.demoPageDTO = demoPageDTO;

        params = new LinkedMultiValueMap<>();
        params.add("name", "codehome");
    }


    /**
     * @title addUser
     * @description todo 测试post接口
     * @author HanYu
     * @updateTime 2021/7/6 12:26
     */
    @Test
    void addUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(demoPageDTO))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.passwd").value("123456"));
    }

    /**
     * @title
     * @description todo 测试get接口
     * @author HanYu
     * @updateTime 2021/7/6 12:26
     */
    @Test
    public void test() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/query")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .params(params)
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse()
                .getContentAsString();
        Assert.assertEquals("调用成功", "codehome", result);
    }

    /**
     * @title
     * @description todo 测试get接口
     * @author HanYu
     * @updateTime 2021/7/6 12:26
     */
    @Test
    public void testGet2() throws Exception {
        String jsonStr = "{\"data\":{\"debit_account_balance_code\":40,\"credit_consume_count\":1,\"debit_start_age\":1,\"debit_consume_sum_code\":2,\"age\":38},\"modelProductId\":55}";
        String content = this.restTemplate.postForObject("/scoreApi/score", jsonStr, String.class);
        Assert.assertEquals(content, "{\"result\":{\"score\":\"300\",\"logit\":21.144779999999997},\"response_code\":\"00\",\"response_msg\":\"success\"}");
    }
}
