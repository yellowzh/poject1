package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.lingnan.usersys.common.exception.DaoException;


public class DBUtils {
	/**
	 * 获取数据库连接
	 * @return  数据库连接对象
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try{
			//加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			String user="scott";
			String password="123456";
			//获取数据库连接对象
			conn=DriverManager.getConnection(url,user,password);
			
		}catch (ClassNotFoundException e) {
			//将异常封装成自定义异常
			//throw new DaoException("不能获取数据库连接，驱动加载失败请查看jar包是否加载成功",e);
			//e.printStackTrace();
		}catch (SQLException e) {
			//将异常封装成自定义异常
			//throw new DaoException("不能获取数据库连接，sql语句执行错误",e);
			//e.printStackTrace();
		}
		//返回连接对象
		return conn;}
	
	/**
	 * 开启事务
	 * @param conn
	 */
	public static void beginTransaction(Connection conn){
		try{
			//将事务提交接口设为假
			conn.setAutoCommit(false);
		}catch(SQLException e){
			//将异常封装成自定义异常
			//throw new DaoException("开启事务失败",e);
			//e.printStackTrace();
		}
	}

	
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void commit(Connection conn){
		try{
			//提交事务
			conn.commit();
			//将事务提交接口设为真
			conn.setAutoCommit(true);
		}catch(SQLException e){
			//将异常封装成自定义异常
			//throw new DaoException("提交事务失败",e);
			//e.printStackTrace();
		}
	}
	
	
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollback(Connection conn){
		try{
			//回滚事务
			conn.rollback();
			//将事自动提交接口设为真
			conn.setAutoCommit(true);
		}catch(SQLException e){
			//将异常封装成自定义异常
			//throw new DaoException("事务回滚失败",e);
			//e.printStackTrace();
		}
	}
	
	
	/**
	 * 关闭数据连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		try{
			//如果数据库连接对象不为空，关闭数据库连接
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			//将异常封装成自定义异常
			//throw new DaoException("关闭连接对象失败",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 关闭statement
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs,Statement stmt){
		try{
			//如果查询结果集对象不为空，则关闭该对象
			if(rs != null){
				rs.close();
			}
			//如果声明对象不为空，则关闭该声明对象
			if(stmt != null){
				stmt.close();
			}
		}catch(SQLException e){
			//将异常封装成自定义异常
			//throw new DaoException("关闭声明对象失败",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 关闭声明对象
	 * @param pstat
	 */
	public static void closePreparedStatement(PreparedStatement pstat){
		try {
			if(pstat!=null){
				pstat.close();
				pstat=null;
			}
		}catch(SQLException e){
			//将异常封装成自定义异常
			//throw new DaoException("关闭声明对象失败",e);
			//e.printStackTrace();
		}
	}



}
