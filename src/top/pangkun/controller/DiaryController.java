package top.pangkun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.pangkun.javabeen.Diary;
import top.pangkun.service.impl.DiaryService;
import top.pangkun.util.TimeUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 庞昆 on 2018/1/25.
 */
@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Resource(name = "diaryService")
    private DiaryService diaryService;
    private static int id = 0;

    @RequestMapping("")
    public ModelAndView diary() {
        ModelAndView mv = new ModelAndView("diary");
        id = 0;
        try {
            List<Diary> allDiary = diaryService.findAssignDiary(id);
            mv.addObject("diary_list", allDiary);
            mv.addObject("ifHaveLast", id > 0);
            mv.addObject("ifHaveNext", allDiary.size() == 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/last")
    public ModelAndView diaryLast() {
        ModelAndView mv = new ModelAndView("diary");
        try {
            if (id < 10) {
                List<Diary> allDiary = diaryService.findAssignDiary(id);
                mv.addObject("diary_list", allDiary);
                mv.addObject("ifHaveLast", id > 0);
                mv.addObject("ifHaveNext", allDiary.size() == 10);
            } else {
                id -= 10;
                List<Diary> allDiary = diaryService.findAssignDiary(id);
                mv.addObject("diary_list", allDiary);
                mv.addObject("ifHaveLast", id > 0);
                mv.addObject("ifHaveNext", allDiary.size() == 10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/next")
    public ModelAndView diaryNext() {
        ModelAndView mv = new ModelAndView("diary");
        try {
            if(diaryService.findAssignDiary(id).size()==10)
                id += 10;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Diary> allDiary = diaryService.findAssignDiary(id);
            mv.addObject("diary_list", allDiary);
            mv.addObject("ifHaveLast", id > 0);
            mv.addObject("ifHaveNext", allDiary.size() == 10);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/submit")
    public ModelAndView submitDiary(HttpServletRequest httpServletRequest) {
        String payload = httpServletRequest.getParameter("payload");
        String title = httpServletRequest.getParameter("title");
        if (payload.equals("") && title.equals("")) {
            return new ModelAndView("diary");
        }
        try {
            diaryService.insertDiary(new Diary(title, payload, TimeUtil.getNowTime()));
//            System.out.println(getDiaryNum());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("diary");
    }

//    private int getDiaryNum() {
//        List<Diary> lastDiary = null;
//        try {
//            lastDiary = diaryService.findLastDiary();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lastDiary.get(0).getId();
//    }
}
