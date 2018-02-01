package mybatis.mapping;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.pangkun.javabeen.Diary;

import java.util.List;

/**
 * Created by 庞昆 on 2018/1/24.
 */
public interface DiaryMapper {

    @Insert("insert into diary values(0,#{time},#{title},#{payload})")
    public void insertDiary(Diary diary) throws Exception;

//    @Select("select * from diary order by id desc limit 10")
//    public List<Diary> findLastDiary() throws Exception;

    @Select("select * from diary order by id desc limit #{id},10")
    public List<Diary>findAssignDiary(int id)throws Exception;
}
