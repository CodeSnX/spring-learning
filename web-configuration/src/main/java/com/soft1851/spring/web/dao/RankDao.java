package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Rank;

import java.util.List;

public interface RankDao {
    /**
     * 批量导入
     *
     * @param ranks
     * @return int[]
     */
    int[] batchInsert(List<Rank> ranks);

    /**
     * 查询所有
     *
     * @return List<Rank></>
     */
    List<Rank> selectAll();
}
