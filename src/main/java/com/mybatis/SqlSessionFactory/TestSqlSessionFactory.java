package com.mybatis.SqlSessionFactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hzzhaolong on 2016/2/16.
 */
public class TestSqlSessionFactory {

    public static void main(String[] args) throws IOException {
        String resource = "sqlsession/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = (Blog) session.selectOne("com.mybatis.SqlSessionFactory.BlogMapper.selectBlog", 1);
            System.out.println(blog);
        } finally {
            session.close();
        }

        session = sqlSessionFactory.openSession();
        try {
            // 注意BlogMapper.java中的包名要和xml中的namespace对应
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(2);
            System.out.println(blog);
        } finally {
            session.close();
        }

        session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog2("ddd");
            System.out.println(blog);
        } finally {
            session.close();
        }

        session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            System.out.println("--------------------------Count-------------------");
            int count = mapper.selectCount();
            System.out.println(count);
        } finally {
            session.close();
        }


        session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            System.out.println("--------------------------Count-------------------");
            Blog blog = new Blog();
            blog.setTitle("ccc");
            mapper.selectBlog3(blog);
            System.out.println(blog);
        } finally {
            session.close();
        }

    }

}
