package com.MarkSource.db;

import com.MarkSource.bean.Source;
import com.MarkSource.bean.User;

import java.sql.*;

public class OperationUser {
    private Connection connection=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    public int intitUser(User user){
        int i=0;
        String sql="insert into user(user_id,user_name,user_pwd) values(?,?,?)";
    try{
    Class.forName(JDBCConnectMysql.DRIVER);
    connection= DriverManager.getConnection(JDBCConnectMysql.DB_URL, JDBCConnectMysql.USER, JDBCConnectMysql.PASSWORD);
    preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setString(1,user.getUser_id());
    preparedStatement.setString(2,user.getUser_name());
    preparedStatement.setString(3,user.getUser_password());
     i=preparedStatement.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){
        e.printStackTrace();
    }finally{
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    return i;
    }

    public User loginUser(String name){
        User user=new User();
        String sql="select user_id,user_name,user_pwd from user where user_name=?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(JDBCConnectMysql.DB_URL, JDBCConnectMysql.USER, JDBCConnectMysql.PASSWORD);
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setUser_id(resultSet.getString("user_id"));
                user.setUser_name(resultSet.getString("user_name"));
                user.setUser_password(resultSet.getString("user_pwd"));
                break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return user;
    }
    public int updatePwd(User user) {
        int i = 0;
        String sql = "update user set user_pwd=?  where user_name=?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUser_password());
            preparedStatement.setString(2, user.getUser_name());
            i = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return i;
    }

    public User selPwd(String name){
        User user=new User();
        String sql="select user_pwd from user where user_name=?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(JDBCConnectMysql.DB_URL, JDBCConnectMysql.USER, JDBCConnectMysql.PASSWORD);
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                /*user.setUser_name(resultSet.getString("user_name"));*/
                user.setUser_password(resultSet.getString("user_pwd"));
                break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return user;
    }

}
