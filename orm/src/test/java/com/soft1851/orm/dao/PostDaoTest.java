package com.soft1851.orm.dao;

import com.soft1851.orm.entity.Post;
import com.soft1851.orm.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/17
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class PostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void insert() throws IOException {
        URL resource = getClass().getClassLoader().getResource("images/1.jpg");
        String path = resource.getPath();
        Post post = Post.builder().postTime(Timestamp.valueOf(LocalDateTime.now()))
                .content("测试").forumId(1).title("测试标题").thumbnail(FileUtil.readImage(path)).build();
        postDao.insert(post);
    }

    @Test
    public void batchInsert() throws IOException {
        List<Post> postList = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            URL resource = getClass().getClassLoader().getResource("images/"+ i + ".jpg");
            String path = resource.getPath();
            Post post = Post.builder().postTime(Timestamp.valueOf(LocalDateTime.now()))
                    .content("测试" + i).forumId(i).title("测试标题" + i).thumbnail(FileUtil.readImage(path)).build();
            postList.add(post);
        }
        int[] rows = postDao.batchInsert(postList);
        assertEquals(3, rows.length);
    }

    @Test
    public void batchDelete() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int[] rows = postDao.batchDelete(list);
        assertEquals(2, rows.length);
    }

    @Test
    public void deleteById() {
        int n = postDao.deleteById(3);
        assertEquals(1, n);
    }

    @Test
    public void getById() {
        Post post = postDao.getById(4);
        assertNotNull(post);
        System.out.println(post);
    }

    @Test
    public void getByKeywords() {
        List<Post> postList = postDao.getByKeywords("测试");
        assertNotNull(postList);
        System.out.println(postList.size());
    }

    @Test
    public void getCount() {
        int n = postDao.getCount();
        assertNotNull(n);
        System.out.println(n);
    }
}