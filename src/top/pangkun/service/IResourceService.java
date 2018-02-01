package top.pangkun.service;

import top.pangkun.javabeen.Resource;

import java.util.List;

/**
 * Created by 庞昆 on 2018/1/30.
 */
public interface IResourceService {

    public void insertResource(Resource resource) throws Exception;

//    public List<Resource> findLastResource() throws Exception;

    public List<Resource>findAssignResource(int id)throws Exception;
}
