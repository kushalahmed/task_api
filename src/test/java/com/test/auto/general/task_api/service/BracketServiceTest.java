package com.test.auto.general.task_api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
public class BracketServiceTest {

    @TestConfiguration
    static class ToDoItemServiceTestContextConfiguration {

        @Bean
        public IBracketService bracketService() {
            return new BracketService();
        }
    }

    @Autowired
    private IBracketService bracketService;

    @Test
    public void whenBalancedBracket_thenIsBalancedTrue() {
        String input = "{}[{()}]";
        boolean isBalanced = bracketService.isBalanced(input);

        assertTrue(isBalanced);
    }

    @Test
    public void whenNotBalancedBracket_thenIsBalancedFalse() {
        String input = "{}[{()}}]";
        boolean isBalanced = bracketService.isBalanced(input);
        assertFalse(isBalanced);

        input = "{";
        isBalanced = bracketService.isBalanced(input);
        assertFalse(isBalanced);

        input = "]";
        isBalanced = bracketService.isBalanced(input);
        assertFalse(isBalanced);

        input = "({})]";
        isBalanced = bracketService.isBalanced(input);
        assertFalse(isBalanced);
    }
}
