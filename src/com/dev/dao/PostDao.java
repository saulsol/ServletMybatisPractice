package com.dev.dao;

import com.dev.controller.util.PageInfo;
import com.dev.dto.CreatePostDto;
import com.dev.dto.PostDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

    public int getTotalPostCount(){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.selectOne("getTotalPostCount");
        session.commit();
        session.close();

        return cnt;
    }

    // 한 페이지당 10개의 게시물이 표현된다.
    public List<PostDto> getPostByPage(int pageNum){

        PageInfo pageInfo = new PageInfo();
        int initSize = 10;
        int realPageNum = pageNum -1;

        pageInfo.setLimit(initSize);
        pageInfo.setOffset(((realPageNum) * 10 ));


        SqlSession session = sqlSessionFactory.openSession();
        List<PostDto> list = session.selectList("getPostByPage", pageInfo);

        session.commit();
        session.close();

        return list;
    }








    static public PostDao getInstance(){
        if(postDao == null){
            postDao = new PostDao();
            return postDao;
        }

        return postDao;
    }


}
