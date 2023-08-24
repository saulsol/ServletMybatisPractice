package com.dev.dao;


import com.dev.dto.UserDto;
import com.dev.dto.UserLoginDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserDao {

    private static UserDao userDao;
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

    public int userInsert(UserDto userDto){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.insert("userInsert", userDto);
        session.commit();
        session.close();

        return cnt;
    }


    public String findByUserIdAndUserPass(UserLoginDto loginDto){

        SqlSession session = sqlSessionFactory.openSession();

         String userId = session.selectOne("findByUserIdAndUserPass", loginDto);

        session.commit();
        session.close();


        return userId;
    }





    static public UserDao getInstance(){
        if(userDao == null){
            userDao = new UserDao();
            return userDao;
        }else{
            return userDao;
        }
    }

}
