package com.ib.springflex.controller;

import com.ib.springflex.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FlexFeatureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFlexHome() throws Exception {
        MvcResult result = mockMvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hey not so stranger :) You are at right place!"))
                .andReturn();

        String response = result.getResponse().getContentAsString();
        assertNotNull(response);
        assertTrue(response.contains("not so stranger"));
    }

    @Test
    public void testLogEndpoint() throws Exception {
        MvcResult result = mockMvc.perform(get("/log")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hey! You can check the output in the logs"))
                .andReturn();

        String response = result.getResponse().getContentAsString();
        assertNotNull(response);
        assertTrue(response.contains("logs"));
    }

    @Test
    public void testLombokEndpoint() throws Exception {
        MvcResult result = mockMvc.perform(get("/lombok")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        assertNotNull(response);
        assertTrue(response.contains("John Doe") || response.contains("Engineering") || response.contains("1"));
    }

    @Test
    public void testFlexHomeReturnsCorrectMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8"));
    }

    @Test
    public void testLogEndpointReturnsCorrectMessage() throws Exception {
        mockMvc.perform(get("/log"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hey! You can check the output in the logs"));
    }

    @Test
    public void testLombokEndpointReturnsEmployee() throws Exception {
        mockMvc.perform(get("/lombok"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.department").value("Engineering"));
    }

    @Test
    public void testMultipleCallsToFlexHome() throws Exception {
        for (int i = 0; i < 3; i++) {
            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hey not so stranger :) You are at right place!"));
        }
    }

    @Test
    public void testMultipleCallsToLog() throws Exception {
        for (int i = 0; i < 3; i++) {
            mockMvc.perform(get("/log"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hey! You can check the output in the logs"));
        }
    }

    @Test
    public void testMultipleCallsToLombok() throws Exception {
        for (int i = 0; i < 3; i++) {
            mockMvc.perform(get("/lombok"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(1))
                    .andExpect(jsonPath("$.name").value("John Doe"))
                    .andExpect(jsonPath("$.department").value("Engineering"));
        }
    }

    @Test
    public void testEndpointResponseContentType() throws Exception {
        mockMvc.perform(get("/lombok"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFlexHomeStatusCode() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testLogStatusCode() throws Exception {
        mockMvc.perform(get("/log"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testLombokStatusCode() throws Exception {
        mockMvc.perform(get("/lombok"))
                .andExpect(status().is2xxSuccessful());
    }
}

