package top.pangkun.service;

import top.pangkun.javabeen.Diary;

import java.util.List;

/**
 * Created by 庞昆 on 2018/1/24.
 */
public interface IDiaryService {

    public void insertDiary(Diary diary) throws Exception;

//    public List<Diary> findLastDiary() throws Exception;

    public List<Diary>findAssignDiary(int id)throws Exception;
}
