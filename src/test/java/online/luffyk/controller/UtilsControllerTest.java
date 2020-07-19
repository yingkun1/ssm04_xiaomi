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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
@WebAppConfiguration
public class UtilsControllerTest {
    @Resource
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testSearch(){
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/u/search/CC")).andReturn();
            String contentAsString = mvcResult.getResponse().getContentAsString();
            System.out.println("context:"+contentAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetGoodsByGoodsType(){
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/u/get/1/101")).andReturn();
            String contentAsString = mvcResult.getResponse().getContentAsString();
            System.out.println("content:"+contentAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
