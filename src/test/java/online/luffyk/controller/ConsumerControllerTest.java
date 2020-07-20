package online.luffyk.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
@WebAppConfiguration
public class ConsumerControllerTest {
    @Resource
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testLogin(){
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consumer/login/auth").param("username", "应昆").param("password", "yingkun9257")).andReturn();
            String contentAsString = mvcResult.getResponse().getContentAsString();
            System.out.println("content:"+contentAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testRegister(){
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consumer/register").param("username", "张飞").param("password", "zhangfei9257").param("email", "zhangfei@qq.com").param("phone", "17373960307")).andReturn();
            String contentAsString = mvcResult.getResponse().getContentAsString();
            System.out.println("content:"+contentAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
