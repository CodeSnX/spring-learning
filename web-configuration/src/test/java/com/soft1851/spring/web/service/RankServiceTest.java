package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.spider.BiLiBiLiSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class RankServiceTest {
    @Autowired
    private RankService rankService;

    @Test
    public void batchInsert() {
        int[] ints = rankService.batchInsert(BiLiBiLiSpider.getRanks());
        assertEquals(BiLiBiLiSpider.getRanks().size(),ints.length);
    }
}