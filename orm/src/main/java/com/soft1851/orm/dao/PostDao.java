package com.soft1851.orm.dao;


import com.soft1851.orm.entity.Post;

import java.util.List;

public interface PostDao {

    /**
     * 单个新增
     * @return int
     */
    int insert(Post post);

    /**
     * 批量新增
     * @param posts
     * @return int[]
     */
    int[] batchInsert(List<Post> posts);

    /**
     * 批量删除
     * @param idList
     * @return int
     */
    int[] batchDelete(List<Integer> idList);

    /**
     * 根据id删除Post
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 根据id查询
     * @param id
     * @return Post
     */
    Post getById(int id);

    /**
     * 根据关键字查询post
     * @return List<Post>
     */
    List<Post> getByKeywords(String keywords);

    /**
     * 同级帖子的数量
     * @return int
     */
    int getCount();
}
