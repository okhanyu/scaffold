package net.ninini.scaffold.interfaces;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: DemoTest
 * @ProjectName scaffold
 * @Description: todo
 * @Author HanYu
 * @Date 2021/7/6 11:48
 * @Version 1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
//@WebMvcTest(DemoController.class)
public class DemoControllerTest {

//    @MockBean
//    DemoApplication demoApplication;

//    @Test
//    public void testScore() throws Exception {
//        given(this.demoApplication.demoApplicationFunc(anyObject(), anyObject())).willReturn(null);
//        String jsonStr = "{\"data\":{\"debit_account_balance_code\":40,\"credit_consume_count\":1,\"debit_start_age\":1,\"debit_consume_sum_code\":2,\"age\":38},\"modelProductId\":5}";
//        RequestBuilder requestBuilder = null;
//        requestBuilder = post("/scoreApi/score").contentType(MediaType.APPLICATION_JSON).content(jsonStr);
//        this.mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().string("{}"));
//    }






}
