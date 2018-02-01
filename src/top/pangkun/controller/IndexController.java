package top.pangkun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 庞昆 on 2018/1/23.
 */
@Controller
@RequestMapping("/")
public class IndexController {


    @RequestMapping("")
    public ModelAndView index(){
        return new ModelAndView("index");
    }


}
