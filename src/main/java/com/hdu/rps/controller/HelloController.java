package com.hdu.rps.controller;

import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SJH on 2017/12/6.
 * @author SJH
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    private Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String hello() {
        logger.info("-----/hello/index-----");
        return "thymeleaf/index";
    }
}
