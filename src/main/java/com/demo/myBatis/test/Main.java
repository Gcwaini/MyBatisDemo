package com.demo.myBatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String args[]){
        //System.out.println(Main.class.getClassLoader().getResource("").getPath());
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Main.class.getClassLoader().getResourceAsStream("mybatis.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.demo.myBatis.mapper.userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        List list = session.selectList(statement);
        for(int i=0;i<list.size();++i){
            System.out.println(list.get(i));
        }
    }
}
