package cn.sxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BaseDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	//�������
	private void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/usersys";
			conn = DriverManager.getConnection(url,"root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//�ر�
	public void close(){
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	//����--���ӣ��޸ģ�ɾ��
	//sql=insert into book(name,price,author,pubDate) values(?,?,?,?)
	public int executeUpdate(String sql,Object...objects){
		try {
			this.getConnection();
			ps = conn.prepareStatement(sql);
			if(objects!=null)//���ò���
				for(int i=0;i<objects.length;i++){
					ps.setObject(i+1,objects[i]);
				}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return -1;
	}
	//��ѯ
	public ResultSet executeQuery(String sql,Object...objects){
		try {
			this.getConnection();
			ps = conn.prepareStatement(sql);
			if(objects!=null)//���ò���
				for(int i=0;i<objects.length;i++){
					ps.setObject(i+1,objects[i]);
				}
			return rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
