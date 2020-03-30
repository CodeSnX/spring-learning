package com.soft1851.orm.dao;


import com.soft1851.orm.entity.Forum;

import java.util.List;

public interface ForumDao {

    /**
     * 插入一条数据
     * @return int
     */
    int insert(Forum forum);

    /**
     * 批量新增
     * @param forums
     * @return int
     */
    int[] batchInsert(List<Forum> forums);

    /**
     * 根据ids删除信息
     * @param forumId
     * @return int
     */
    int delete(int forumId);

    /**
     * 修改信息
     * @param forum
     * @return int
     */
    int update(Forum forum);

    /**
     * 根据forumId获取信息
     * @param forumId
     * @return Forum
     */
    Forum get(int forumId);

    /**
     * 查询所有论坛信息
     * @return List<Forum>
     */
    List<Forum> selectAll();
}
