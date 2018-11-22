package com.demo.myBatis.databaseConnect;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnect {
    // 连接数据库，以及操作数据
    // 定义加载驱动地址
    private static String DBDRIVER = "";
    // 定义连接地址
    private static String DBURL = "";
    // 数据库用户名和密码
    private static String DBUSER = "";
    private static String DBPASSWORD = "";
    // 读取数据库配置文件
    static {
        InputStream input = DataBaseConnect.class.getClassLoader().getResourceAsStream("database.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("数据库文件加载失败！");
            e.printStackTrace();
        }
        DBDRIVER = properties.getProperty("driver");
        DBURL = properties.getProperty("url");
        DBUSER = properties.getProperty("username");
        DBPASSWORD = properties.getProperty("password");
        try {
            // 加载驱动；
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 返回一个数据库连接对象
    public static Connection getConnect() {
        Connection conn = null;
        try {
            // 连接数据库；
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            System.out.println("连接数据库成功");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("连接失败");
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnect();
    }
}
