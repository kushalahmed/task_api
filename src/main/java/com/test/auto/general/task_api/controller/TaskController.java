package com.test.auto.general.task_api.controller;

import com.test.auto.general.task_api.service.IBracketService;
import com.test.auto.general.task_api.vo.BracketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Rest controller for API calls starting with /tasks. It uses BracketService for underlying business logic.
 */
@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private IBracketService bracketService;

    /**
     * Serves GET /tasks/validateBrackets?input={string of brackets}.
     *
     * The query parameters are identified by the BracketVO value object. It checks if the given string of
     * brackets is balanced or not, and incorporates results in a BracketVO value object.
     *
     * MethodArgumentNotValidException and BindException are thrown if not validated.
     *
     * @param   bracketVO   a BracketVO value object capturing the input string of brackets.
     * @return  a BracketVO value object incorporating the results.
     */
    @RequestMapping(value = "/validateBrackets", method = RequestMethod.GET)
    public BracketVO validateBracket(@Validated @ModelAttribute BracketVO bracketVO) {
        bracketVO.setBalanced(bracketService.isBalanced(bracketVO.getInput()));
        return bracketVO;
    }
}
