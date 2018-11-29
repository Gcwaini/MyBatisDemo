package com.demo.myBatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {
        String resource = "mybatis.xml";
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        String statement = "com.demo.myBatis.dao.UserDao.getAllUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        List list = session.selectList(statement);
        for(int i=0;i<list.size();++i){
            System.out.println(list.get(i));
        }
    }
}
