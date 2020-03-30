package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

public interface TopicService {
    /**
     * 查询所有Topic
     *
     * @return List<Topic>
     */
    List<Topic> queryAll();

    /**
     * 批量插入
     *
     * @param topics
     * @return int[]
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增Topic
     *
     * @param topic
     * @return int
     */
    void addTopic(Topic topic);
}
