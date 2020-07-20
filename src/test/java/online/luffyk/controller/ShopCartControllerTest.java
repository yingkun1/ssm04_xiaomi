package online.luffyk.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ShopCartControllerTest {
    @Resource
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAddGoodsToGoodsCart(){
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/goodsCart/add/7")).andReturn();
            String contentAsString = mvcResult.getResponse().getContentAsString();
            System.out.println("context:"+contentAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
