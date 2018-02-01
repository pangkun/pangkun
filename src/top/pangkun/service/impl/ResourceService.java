package top.pangkun.service.impl;

import mybatis.mapping.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import top.pangkun.javabeen.Resource;
import top.pangkun.service.IResourceService;

import java.util.List;

/**
 * Created by 庞昆 on 2018/1/30.
 */
public class ResourceService implements IResourceService{

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public void insertResource(Resource resource) throws Exception {
        resourceMapper.insertResource(resource);
    }

//    @Override
//    public List<Resource> findLastResource() throws Exception {
//        return resourceMapper.findLastResource();
//    }

    @Override
    public List<Resource> findAssignResource(int id) throws Exception {
        return resourceMapper.findAssignResource(id);
    }
}
