package com.myorg.samplespringboot.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@WebMvcTest(value = {Router.class, SwaggerRouter.class}, secure = false)
public class RouterTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private Router router;

    @Test
    public void ensure_swagger_path_is_available() {

        MvcResult mvcResult = null;
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

        try {
            mvcResult = mockMvc.perform(requestBuilder).andReturn();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(HttpStatus.MOVED_TEMPORARILY.value(), mvcResult.getResponse().getStatus());
    }

    /**
     * No longer required, as partition logic added
     */
    @Test
    public void ensure_valid_tactical_expire_path_is_available() {

        MvcResult mvcResult = null;

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/sample/message");

        try {
            mvcResult = mockMvc.perform(requestBuilder).andReturn();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        try {
            Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
        } catch (UnsupportedEncodingException e) {
            Assert.fail(e.getMessage());
        }
    }
}
