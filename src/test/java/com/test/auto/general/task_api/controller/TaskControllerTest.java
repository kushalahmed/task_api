package com.test.auto.general.task_api.controller;

import com.test.auto.general.task_api.service.IBracketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IBracketService bracketService;

    @Test
    public void givenBalancedBrackets_whenValidateBracketsCalled_thenReturnTrue()
            throws Exception {

        String input = "()";

        // given
        given(bracketService.isBalanced(input)).willReturn(true);

        // when and then
        mvc.perform(get("/tasks/validateBrackets?input=" + input)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("input").value(input))
                .andExpect(jsonPath("isBalanced").value(true));
    }

    @Test
    public void givenNotBalancedBrackets_whenValidateBracketsCalled_thenReturnFalse()
            throws Exception {

        String input = "())";

        // given
        given(bracketService.isBalanced(input)).willReturn(false);

        // when and then
        mvc.perform(get("/tasks/validateBrackets?input=" + input)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("input").value(input))
                .andExpect(jsonPath("isBalanced").value(false));
    }
}
