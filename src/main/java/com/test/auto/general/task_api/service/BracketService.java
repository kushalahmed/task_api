package com.test.auto.general.task_api.service;

import org.springframework.stereotype.Service;

import java.util.Stack;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Service class for tasks on brackets
 */
@Service
public class BracketService implements IBracketService {

    /**
     * It checks whether the given bracket string is balanced or not.
     *
     * It iterates over the string, keeps pushing first bracket elements on to a stack, and keeps popping
     * if the other pair is encountered. After the push and pop operations, the stack must be empty.
     * @param   input   string of brackets
     * @return  true if the string of brackets is balanced, false otherwise
     */
    @Override
    public boolean isBalanced(String input) {
        Stack stack = new Stack();
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }
            else if (c == ']' || c == '}' || c == ')') {
                if (stack.empty()) return false;

                char d = (char) stack.pop();
                if (c - d > 2) return false; // checking ascii value: difference is either 1 or 2
            }
        }
        if (stack.empty()) return true;

        return false;
    }
}
