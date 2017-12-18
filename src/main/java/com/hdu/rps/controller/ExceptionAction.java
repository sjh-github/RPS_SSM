package com.hdu.rps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * Created by SJH on 2017/11/10.
 * @author SJH
 * 错误界面映射
 */
@Controller
public class ExceptionAction {
    private Logger logger = Logger.getLogger(String.valueOf(ExceptionAction.this));

    /**
     * 404错误映射
     * @return
     */
    @RequestMapping("/404")
    public String notFountException() {
        logger.warning("---------------404错误-----------------");
        return "thymeleaf/404error";
    }

    /**
     * 405错误映射
     * @return
     */
    @RequestMapping("/405")
    public String notAllowedException() {
        logger.warning("---------------405错误-----------------");
        return "thymeleaf/index";
    }
}
