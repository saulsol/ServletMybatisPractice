package com.dev.dao;

import com.dev.dto.CreatePostDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class PostDao {

    private static PostDao postDao;
    private static final SqlSessionFactory sqlSessionFactory;


    static {
        InputStream inputStream;

        String resource = "/com/dev/myBatis/config.xml";

        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int postInsert(CreatePostDto createPostDto){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.insert("postInsert", createPostDto);

        session.commit();
        session.close();

        return cnt;
    }









    static public PostDao getInstance(){
        if(postDao == null){
            postDao = new PostDao();
            return postDao;
        }

        return postDao;
    }


}
