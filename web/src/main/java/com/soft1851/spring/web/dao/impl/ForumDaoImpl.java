//package com.soft1851.spring.web.dao.impl;
//
//import com.soft1851.spring.web.dao.ForumDao;
//import com.soft1851.spring.web.entity.Forum;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import java.util.List;
//
//@Component
//public class ForumDaoImpl implements ForumDao {
//    private JdbcTemplate jdbcTemplate;
//
//    public ForumDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Forum get(int forumId) {
//        String sql = "SELECT * FROM t_forum WHERE forum_id =?";
//        Object[] args = {forumId};
//        return jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(Forum.class));
//    }
//
//    @Override
//    public List<Forum> selectAll() {
//        String sql = "SELECT * FROM t_forum";
//        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Forum.class));
//    }
//
//    @Override
//    public List<Forum> getByKeywords(String keywords) {
//        String sql = "SELECT * FROM t_forum WHERE forum_name LIKE '%' ? '%'";
//        Object[] args = {keywords};
//        return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(Forum.class));
//    }
//}
//
