package com.soft1851.orm.dao.impl;

import com.soft1851.orm.dao.PostDao;
import com.soft1851.orm.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post VALUES (NULL, ?, ?, ?, ?, ?)";
        Object[] args = {post.getForumId(), post.getTitle(), post.getContent(), post.getThumbnail(),post.getPostTime()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL, ?, ?, ?, ?, ?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, postList.get(i).getForumId());
                preparedStatement.setString(2, postList.get(i).getTitle());
                preparedStatement.setString(3, postList.get(i).getContent());
                preparedStatement.setBytes(4, postList.get(i).getThumbnail());
                preparedStatement.setTimestamp(5, postList.get(i).getPostTime());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public int[] batchDelete(List<Integer> idList) {
     String sql = "DELETE FROM t_post WHERE post_id= ?";
     return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
         @Override
         public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
             preparedStatement.setInt(1, idList.get(i));
         }

         @Override
         public int getBatchSize() {
             return idList.size();
         }
     });
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Post getById(int id) {
        String sql = "SELECT * FROM t_post WHERE post_id = ?";
        Object[] args = {id};
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> getByKeywords(String keywords) {
        String sql = "SELECT * FROM t_post WHERE title LIKE '%' ? '%'";
        Object[] args = {keywords};
        return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public int getCount() {
        String sql = "SELECT * FROM t_post";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class)).size();
    }
}
