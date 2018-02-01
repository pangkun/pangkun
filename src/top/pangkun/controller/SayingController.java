package top.pangkun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 庞昆 on 2018/1/23.
 */
@Controller
@RequestMapping("/saying")
public class SayingController {
    @RequestMapping("")
    public ModelAndView s(){
        ModelAndView mv=new ModelAndView("saying");
        return mv;
    }
}
