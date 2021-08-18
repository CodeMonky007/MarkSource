package com.MarkSource.db;

import com.MarkSource.bean.Source;

import java.sql.*;
import java.util.ArrayList;

public class OperationSource {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public int initSource(Source source) {
        int i = 0;
        String sql = "insert into source(source_id,source_type,source_des,source_link,create_time,source_location)values(?,?,?,?,?,?)";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL, JDBCConnectMysql.USER, JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, source.getSource_id());
            preparedStatement.setString(2, source.getSource_type());
            preparedStatement.setString(3, source.getSource_des());
            preparedStatement.setString(4, source.getSource_link());
            preparedStatement.setString(5, source.getCreate_time());
            preparedStatement.setString(6, source.getSource_location());
            i = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
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
    public ArrayList<Source> selNetSource(Integer starItme,Integer stopTtme) {

        int i = 0;
        ArrayList<Source> sources = new ArrayList<>();
        String sql = "select source_id,source_type,source_des,source_link,source_location from source where source_location='网络资源' order by create_time desc limit ?,?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,starItme);
            preparedStatement.setInt(2,stopTtme);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Source source = new Source();
                i++;
                source.setSource_id(resultSet.getString("source_id"));
                source.setSource_type(resultSet.getString("source_type"));
                source.setSource_des(resultSet.getString("source_des"));
                source.setSource_link(resultSet.getString("source_link"));
                source.setSource_location(resultSet.getString("source_location"));
                sources.add(source);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return sources;
    }

    public ArrayList<Source> sels_net(Integer starItme,Integer stopTtme,String sels_net) {

        int i = 0;
        ArrayList<Source> sources = new ArrayList<>();
        String sql = "select source_id,source_type,source_des,source_link,source_location from source where source_location='网络资源' " +
                "and source_type like '%"+sels_net+"%'\torder by create_time desc limit ?,?";
        //  and source_des like '%"+sels_net+"%'
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,starItme);
            preparedStatement.setInt(2,stopTtme);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Source source = new Source();
                i++;
                source.setSource_id(resultSet.getString("source_id"));
                source.setSource_type(resultSet.getString("source_type"));
                source.setSource_des(resultSet.getString("source_des"));
                source.setSource_link(resultSet.getString("source_link"));
                source.setSource_location(resultSet.getString("source_location"));
                sources.add(source);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return sources;
    }

    public ArrayList<Source> sels_local(Integer starItme,Integer stopTtme,String sel_localSource) {

        int i = 0;
        ArrayList<Source> sources = new ArrayList<>();
        String sql = "select source_id,source_type,source_des,source_link,source_location from source where source_location='本地资源' " +
                "and source_type like '%"+sel_localSource+"%'\torder by create_time desc limit ?,?";
        //  and source_des like '%"+sel_localSource+"%'
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,starItme);
            preparedStatement.setInt(2,stopTtme);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Source source = new Source();
                i++;
                source.setSource_id(resultSet.getString("source_id"));
                source.setSource_type(resultSet.getString("source_type"));
                source.setSource_des(resultSet.getString("source_des"));
                source.setSource_link(resultSet.getString("source_link"));
                source.setSource_location(resultSet.getString("source_location"));
                sources.add(source);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return sources;
    }

    public ArrayList<Source> selLocalSource(Integer starItme,Integer stopTtme) {

        int i = 0;
        ArrayList<Source> sources = new ArrayList<>();
        String sql = "select source_id,source_type,source_des,source_link,source_location from source where source_location='本地资源' order by create_time desc limit ?,?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,starItme);
            preparedStatement.setInt(2,stopTtme);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Source source = new Source();
                i++;
                source.setSource_id(resultSet.getString("source_id"));
                source.setSource_type(resultSet.getString("source_type"));
                source.setSource_des(resultSet.getString("source_des"));
                source.setSource_link(resultSet.getString("source_link"));
                source.setSource_location(resultSet.getString("source_location"));
                sources.add(source);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return sources;
    }

    public int update_netSource(Source source) {
        int i = 0;
        String sql = "update source set source_type=?,source_des=?,source_link=? where source_id=?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, source.getSource_type());
            preparedStatement.setString(2, source.getSource_des());
            preparedStatement.setString(3, source.getSource_link());
            preparedStatement.setString(4, source.getSource_id());
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

    public int update_localSource(Source source) {
        int i = 0;
        String sql = "update source set source_type=? ,source_des=?,source_link=? where source_id=?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, source.getSource_type());
            preparedStatement.setString(2, source.getSource_des());
            preparedStatement.setString(3, source.getSource_link());
            preparedStatement.setString(4, source.getSource_id());
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

    public int del_netSource(String source_id) {
        int i = 0;
        String sql = "delete from source  where source_id=?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, source_id);

            i = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
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

    public int del_localSource(String source_id) {
        int i = 0;
        String sql = "delete from source  where source_id=?";
        try {
            Class.forName(JDBCConnectMysql.DRIVER);
            connection = DriverManager.getConnection(JDBCConnectMysql.DB_URL,
                    JDBCConnectMysql.USER,
                    JDBCConnectMysql.PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, source_id);

            i = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
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
}