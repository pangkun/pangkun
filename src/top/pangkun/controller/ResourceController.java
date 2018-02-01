package top.pangkun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.pangkun.javabeen.Resource;
import top.pangkun.service.impl.ResourceService;
import top.pangkun.util.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 庞昆 on 2018/1/30.
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    
    @javax.annotation.Resource(name="resourceService")
    private ResourceService resourceService;
    private static int id = 0;

    @RequestMapping("")
    public ModelAndView resource() {
        ModelAndView mv = new ModelAndView("resource");
        id = 0;
        try {
            List<Resource> assignResource = resourceService.findAssignResource(id);
            mv.addObject("resource_list", assignResource);
            mv.addObject("ifHaveLast", id > 0);
            mv.addObject("ifHaveNext", assignResource.size() == 50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/last")
    public ModelAndView resourceLast() {
        ModelAndView mv = new ModelAndView("resource");
        try {
            if (id < 50) {
                List<Resource> assignResource = resourceService.findAssignResource(id);
                mv.addObject("resource_list", assignResource);
                mv.addObject("ifHaveLast", id > 0);
                mv.addObject("ifHaveNext", assignResource.size() == 50);
            } else {
                id -= 50;
                List<Resource> assignResource = resourceService.findAssignResource(id);
                mv.addObject("resource_list", assignResource);
                mv.addObject("ifHaveLast", id > 0);
                mv.addObject("ifHaveNext", assignResource.size() == 50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/next")
    public ModelAndView resourceNext() {
        ModelAndView mv = new ModelAndView("resource");
        try {
            if(resourceService.findAssignResource(id).size()==50)
                id += 50;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Resource> assignResource = resourceService.findAssignResource(id);
            mv.addObject("resource_list", assignResource);
            mv.addObject("ifHaveLast", id > 0);
            mv.addObject("ifHaveNext", assignResource.size() == 50);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/submit")
    public ModelAndView submitResource(HttpServletRequest httpServletRequest) {
        String url = httpServletRequest.getParameter("url");
        String title = httpServletRequest.getParameter("title");
        if (url.equals("") && title.equals("")) {
            return new ModelAndView("resource");
        }
        try {
            resourceService.insertResource(new Resource(title, url, TimeUtil.getNowTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("resource");
    }

}
