package com.barry.security.controller;

import com.barry.security.base.AbstractBaseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * https://www.iteye.com/blog/tobato-2315174
 * */

public class ControllerUriTest extends AbstractBaseService {

    private static final Logger log = LoggerFactory.getLogger(ControllerUriTest.class);

    @Test
    public void whenQuery() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username", "张三")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    public void whenFileUpload() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.multipart("/upload")
                .file(new MockMultipartFile("file", "test.txt",
                        "multipart/form-data", "this a mock multipart file testing".getBytes("UTF-8"))))
        .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentType();
        log.info("====whenFileUpload=======>"+result);
    }

    @Test
    public void upload2() throws Exception {
        MockMultipartFile firstFile = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
        MockMultipartFile secondFile = new MockMultipartFile("data", "other-file-name.data", "text/plain", "some other type".getBytes());
        MockMultipartFile jsonFile = new MockMultipartFile("json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload2")
                .file(firstFile)
                .file(secondFile)
                .file(jsonFile)
                .param("some-random", "4"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(content().string("success"));
    }

}
