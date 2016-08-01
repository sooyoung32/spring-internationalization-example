package com.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by Sooyoung on 2016-07-29.
 */
@Controller
public class TestController {
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String home(Model model
            , Locale locale
            , HttpServletRequest request
            , HttpServletResponse response
    ) {
        System.out.println("client locale is "+locale);
        model.addAttribute("hello", "Hello World");
        return "test";
    }
    
}
