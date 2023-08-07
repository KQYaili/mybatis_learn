package com.lgd.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> local=new ThreadLocal<>();
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory=builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  SqlSessionFactory getFactory(){
        return factory;
    }
    //手动事务管理
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }
    //自动事务管理
    public static SqlSession getSqlSession(boolean isAutoCommit){
        SqlSession sqlSession=local.get();
        if(sqlSession==null){
            //通过SqlSessionFactory调用openSession对象时，通过参数设置事务是否自动提交
            sqlSession= factory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }
    public static <T extends Object>T getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
    }
}
