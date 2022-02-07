package com.euvic.dbcopy.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @Transactional
    void shouldGetThreeBooks() throws Exception {
        // when
        MvcResult mvcResult = mockMvc.perform(get("/count"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        // then
        ObjectNode objectNode = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ObjectNode.class);
        assertThat(objectNode).isNotNull();
        assertThat(objectNode.get("bookCount").toString()).isEqualTo("3");
        assertThat(objectNode.get("copiedBookCount").toString()).isEqualTo("3");
    }

}
