package com.mybatis.SqlSessionFactory;

import org.apache.ibatis.annotations.Select;

/**
 * Created by hzzhaolong on 2016/2/16.
 */
public interface BlogMapper {

    Blog selectBlog(int id);

    @Select("SELECT * FROM blog WHERE title = #{title}")
    Blog selectBlog2(String title);

    Blog selectBlog3(Blog blog);

    int selectCount();
}
