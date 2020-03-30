package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
//事务回滚
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicDao topicDao;

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        return topicDao.batchInsert(topics);
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
        try {
            int a = 1 / 0;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
            //事务回滚
        }
    }
}
