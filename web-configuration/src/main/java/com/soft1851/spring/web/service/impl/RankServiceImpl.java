package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.RankDao;
import com.soft1851.spring.web.entity.Rank;
import com.soft1851.spring.web.service.RankService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RankServiceImpl implements RankService {
    @Resource
    private RankDao rankDao;

    @Override
    public List<Rank> queryAll() {
        return rankDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Rank> ranks) {

        return rankDao.batchInsert(ranks);
    }

}

