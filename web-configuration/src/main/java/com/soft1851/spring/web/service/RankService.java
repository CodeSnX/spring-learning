package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Rank;
import com.soft1851.spring.web.entity.Topic;

import java.util.List;

public interface RankService {
    /**
     * 查询所有Rank
     *
     * @return List<Rank>
     */
    List<Rank> queryAll();

    /**
     * 批量插入
     *
     * @param ranks
     * @return int[]
     */
    int[] batchInsert(List<Rank> ranks);

}
