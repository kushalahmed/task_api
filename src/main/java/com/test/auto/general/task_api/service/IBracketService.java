package com.test.auto.general.task_api.service;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Service class for tasks on brackets
 */
public interface IBracketService {

    /**
     * Checks if the given 'input' string of brackets is a balanced one.
     * Brackets in a string are considered to be balanced if the following criteria are met:
     * (1) For every opening bracket (i.e., (, {, or [), there is a matching closing bracket (i.e., ), }, or ])
     * of the same type (i.e., ( matches ), { matches }, and [ matches ]). An opening bracket must appear
     * before (to the left of) its matching closing bracket. For example, ]{}[ is not balanced.
     * (2) No unmatched braces lie between some pair of matched bracket.
     * For example, ({[]}) is balanced, but {[}] and [{)] are not balanced.
     *
     * @param   input   a string of brackets
     * @return  true    if the string of brackets is balanced, 'false' otherwise.
     */
    boolean isBalanced(String input);
}
