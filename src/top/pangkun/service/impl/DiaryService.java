package top.pangkun.service.impl;

import mybatis.mapping.DiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import top.pangkun.javabeen.Diary;
import top.pangkun.service.IDiaryService;

import java.util.List;

/**
 * Created by 庞昆 on 2018/1/24.
 */
public class DiaryService implements IDiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public void insertDiary(Diary diary) throws Exception {
        diaryMapper.insertDiary(diary);
    }

//    @Override
//    public List<Diary> findLastDiary() throws Exception {
//        return diaryMapper.findLastDiary();
//    }

    @Override
    public List<Diary> findAssignDiary(int id) throws Exception {
        return diaryMapper.findAssignDiary(id);
    }
}
