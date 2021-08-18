package com.MarkSource.db;

public class JDBCConnectMysql {
    /*
    * DB_URL：链接数据库的URL，里面包含数据库名，数据库IP，数据开放的
    * 端口号，链接时间等。
    *
    * USER：表示连接数据库的用户名
    * PASSWORD:表示连接数据库的密码
    * DRIVER：表示连接数据库的驱动
    * */
    public static final String DB_URL="jdbc:mysql://127.0.0.1:3306/marksource?&useSSL=false&serverTimezone=UTC";
    public static final String USER="root";
    public static final String PASSWORD="123456";
    public static final String DRIVER="com.mysql.cj.jdbc.Driver";

}
