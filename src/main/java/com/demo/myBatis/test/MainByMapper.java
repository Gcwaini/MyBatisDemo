package com.demo.myBatis.test;

import com.demo.myBatis.dao.UserDao;
import com.demo.myBatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MainByMapper {

    public static void main(String args[]){
        //System.out.println(Main.class.getClassLoader().getResource("").getPath());
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Main.class.getClassLoader().getResourceAsStream("mybatis.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        /*
        List list = userDao.getAllUser();
        for(int i=0;i<list.size();++i){
            System.out.println(list.get(i));
        }
        */
        /*
        List list = userDao.getSomeUser(1,"123456");
        for(int i=0;i<list.size();++i){
            System.out.println(list.get(i));
        }
        */
        List list = userDao.getPartUser("小李");
        for(int i=0;i<list.size();++i){
            System.out.println(list.get(i));
        }
       /*
        User user = new User();
        user.setId(1);
        user.setPassword("123456");
        List list = userDao.getOneUser(user);
        for(int i=0;i<list.size();++i){
            System.out.println(list.get(i));
        }
        */
    }

}
