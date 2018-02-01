package mybatis.mapping;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.pangkun.javabeen.Resource;

import java.util.List;

/**
 * Created by 庞昆 on 2018/1/30.
 */
public interface ResourceMapper {

    @Insert("insert into resource values(0,#{time},#{title},#{url})")
    public void insertResource(Resource resource) throws Exception;

//    @Select("select * from resource order by id desc limit 50")
//    public List<Resource> findLastResource() throws Exception;

    @Select("select * from resource order by id desc limit #{id},50")
    public List<Resource>findAssignResource(int id)throws Exception;

}
