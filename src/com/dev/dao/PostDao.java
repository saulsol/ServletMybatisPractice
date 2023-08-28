package com.dev.dao;

import com.dev.controller.util.PageInfo;
import com.dev.dto.*;
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







    public PostDto findById(int postNum){
        SqlSession session = sqlSessionFactory.openSession();
        PostDto postDto = session.selectOne("findById", postNum);

        session.commit();
        session.close();

        return postDto;
    }

    // 이미 좋아요를 눌렀을 때 1이 나오고
    // 없으면 0이 나온다.
    public int isAlreadyLikes(String userId, int postNum){
        FindLikesDto likesDto = new FindLikesDto(userId, postNum);
        SqlSession session = sqlSessionFactory.openSession();

        int check = session.selectOne("isAlreadyLikes",likesDto);

        session.commit();
        session.close();


        return check;
    }

    public int isAlreadyDisLikes(String userId, int postNum){
        FindLikesDto likesDto = new FindLikesDto(userId, postNum);
        SqlSession session = sqlSessionFactory.openSession();

        int check = session.selectOne("isAlreadyDisLikes",likesDto);

        session.commit();
        session.close();

        return check;
    }

    public int countPostLikes(int postNum){

        SqlSession session = sqlSessionFactory.openSession();

        int likesCount = session.selectOne("countPostLikes", postNum);

        session.commit();
        session.close();

        return likesCount;
    }

    public int countPostDisLikes(int postNum){

        SqlSession session = sqlSessionFactory.openSession();

        int likesCount = session.selectOne("countPostDisLikes", postNum);

        session.commit();
        session.close();

        return likesCount;
    }

    public void insertLikes(LikesDto likesDto){
        SqlSession session = sqlSessionFactory.openSession();

        session.insert("insertLikes",likesDto);

        session.commit();
        session.close();
    }

    public void insertDisLikes(DisLikesDto disLikesDto){
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("insertDisLikes", disLikesDto);
        session.commit();
        session.close();
    }

    public List<PostDto> postSearch(int pageNum, String postTitle, String postContent){
        SqlSession session = sqlSessionFactory.openSession();

        int initSize = 10;
        int realPAgeNum = pageNum -1;

        SearchPostDto searchPostDto = new SearchPostDto();
        searchPostDto.setLimit(initSize);
        searchPostDto.setOffset(realPAgeNum * 10);
        searchPostDto.setPostTitle(postTitle);
        searchPostDto.setPostContent(postContent);

        List<PostDto> searchList = session.selectList("postSearch", searchPostDto);

        session.commit();
        session.close();

        return searchList;
    }

    public int postSearchCount(PostSearchCountDto postSearchCountDto){
        SqlSession session = sqlSessionFactory.openSession();

        int count = session.selectOne("postSearchCount", postSearchCountDto);

        session.commit();
        session.close();

        return count;
    }

    public int userLikesPostCount (String userId){
        SqlSession session = sqlSessionFactory.openSession();

        int count = session.selectOne("userLikesPostCount", userId);

        session.commit();
        session.close();

        return count;
    }

    public List<PostDto> userLikesPost(String userId, int pageNum){
        SqlSession session = sqlSessionFactory.openSession();
        UserLikesPostDto userLikesPostDto = new UserLikesPostDto();

        int initSize = 10;
        int realPageNum = (pageNum -1) * 10;

        userLikesPostDto.setUserId(userId);
        userLikesPostDto.setLimit(initSize);
        userLikesPostDto.setOffset(realPageNum);


        List<PostDto> list = session.selectList("userLikesPost", userLikesPostDto);
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
