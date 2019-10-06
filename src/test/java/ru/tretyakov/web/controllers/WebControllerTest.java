package ru.tretyakov.web.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.tretyakov.data.service.impl.StartupServiceImpl;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@ContextConfiguration(locations = "classpath:test-ctx-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:test.properties")
public class WebControllerTest {

    private static final String TEST_XML_FILEPATH = "./src/main/resources/test.xml";

    @Autowired
    private WebController controller;

    @Autowired
    private StartupServiceImpl startup;

    private MockMvc mvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
        startup.run(new DefaultApplicationArguments(new String[] {TEST_XML_FILEPATH}));
    }

    @Test
    public void test001_controller_not_null() {
        assertNotNull(this.controller);
        assertNotNull(this.mvc);
    }

    @Test
    public void test002_when_lookup_empty_request_body() throws Exception {
        mvc.perform(post("/items/lookup")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void test003_when_lookup_by_request_body() throws Exception {
        mvc.perform(post("/items/lookup")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"box\":\"1\",\"color\":\"red\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[2,3]"));
    }

    @Test
    public void test004_when_lookup_by_wrong_request_body_param() throws Exception {
        mvc.perform(post("/items/lookup")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().is4xxClientError());
    }

}